package cn.zzy.annotation.RedisCacheAnnotaion;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/19 16:10
 * @PackageName:cn.zzy.annotaions.RedisCacheAnnotaion
 * @ClassName: RedisCacheAspect
 * @Description: TODO
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class RedisCacheAspect {

    @Pointcut("@annotation(cn.zzy.annotation.RedisCacheAnnotaion.RedisCache)")
    private void pointcut() {}

    @Autowired
    private RedisTemplate<String, Object> redisTemplate; // 统一存为String的value

    @Around("pointcut()")

    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        String key = generate_key(method);
        log.info("生成key为：{}", key);
        RedisCache annotation = method.getAnnotation(RedisCache.class);
        // 根据key去查redis
        Object value = redisTemplate.opsForValue().get(key);
        log.info("查询redis缓存的的结果：{}", value);
        // 查到就直接返回
        if (!StringUtils.isEmpty(value)) {
            log.info("本次查询读取了redis缓存");
            return value;
        } else {
            // 查不到正常执行方法逻辑，并且将结果存进redis作为缓存
            try {
                Object result = pjp.proceed();
                if (Objects.nonNull(result)) {
                    // 如果查到数据，按用户设置的来设置过期时间
                    redisTemplate.opsForValue().set(key, result, annotation.time(), annotation.timeunit());
                } else {
                    // 否则将key-null写入缓存，但是设置短过期时间，防止缓存穿透且对内存友好
                    redisTemplate.opsForValue().set(key, new Object(), 5, TimeUnit.MINUTES);
                }

                return result;
            } catch (Exception e) {
                log.info("方法{}执行出错: {}", method.getName(), e.getMessage());
            }
        }
        return new Object();
    }

    // 生成key
    public String generate_key(Method method) {
        RedisCache redisCache = method.getAnnotation(RedisCache.class);
        // 组装key，优先使用赋值，否则拼接方法名和参数名
        StringBuilder key = new StringBuilder(redisCache.keyPrefix());
        if (redisCache.key().equals("")) {
            String paramString =
                Arrays.stream(method.getParameters()).map(Parameter::getName).collect(Collectors.joining("-"));
            key.append(method.getName()).append(paramString);
        } else {
            key.append(redisCache.key());
        }
        return key.toString();
    }

}

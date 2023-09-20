package cn.zzy.annotaions.RedisCacheAnnotaion;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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

    @Pointcut("@annotation(cn.zzy.annotaions.RedisCacheAnnotaion.RedisCache)")
    private void pointcut() {
    }

    @Around("pointcut()")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        try {
            Object result = pjp.proceed();
            
            return result;
        } catch (Exception e) {
            log.info("方法{}执行出错: {}", method.getName(), e.getMessage());
        }


        return new Object();
    }


}

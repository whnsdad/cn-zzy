package cn.zzy.annotation;

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
 * @Date 2023/9/17 16:13
 * @PackageName:cn.zzy.annotation
 * @ClassName: LogOnAopAspect
 * @Description: TODO
 * @Version 1.0
 */
@Aspect
@Component(value = "LogOnAopAspect")
@Slf4j
public class LogOnAopAspect {

    @Pointcut("@annotation(cn.zzy.annotation.LogOnAop)")  // 定义切点，@annotation捕获注解、@execution捕获方法
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object logBeforeMethod(ProceedingJoinPoint joinPoint) {
        if (checkAnnotation(joinPoint)) {
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            String methodName = method.getName();
            Object[] args = joinPoint.getArgs();
            log.info("方法’{}‘有{}个入参：", methodName, args.length);
            for (int i = 0; i < args.length; i++) {
                log.info("第{}个入参为：{}", i, args[i]);
            }
            try {
                Object result = joinPoint.proceed();
                log.info(String.valueOf(result.getClass()));
                log.info("方法’{}‘的返参为：{}", methodName, result);
                return result;
            } catch (Throwable e) {
                log.warn("方法’{}‘执行失败：{}", methodName, e.getMessage());
            }
        }
        return new Object();
    }

    public boolean checkAnnotation(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method == null) return false;
        return method.getAnnotation(LogOnAop.class).enabled();
    }
}

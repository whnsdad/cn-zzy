package cn.zzy.annotaions.LogPrintAnnotation;

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
 * @Date 2023/9/19 15:21
 * @PackageName:cn.zzy.annotaions.LogPrintAnnotation
 * @ClassName: LogPrintAspect
 * @Description: TODO
 * @Version 1.0
 */
@Aspect
@Slf4j
@Component
public class LogPrintAspect {

    @Pointcut("@annotation(cn.zzy.annotaions.LogPrintAnnotation.LogPrint)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        log.info("方法{}开始执行，参数数量{}", methodName, method.getParameterCount());
        try {
            Object result = pjp.proceed();
            log.info("方法{}执行成功，返回类型{}", methodName, result.getClass());
            return result;
        } catch (Exception e) {
            log.info("方法{}执行异常: {}", methodName, e.getMessage());
        }

        return new Object();
    }
}

package cn.zzy.annotaions.LogPrintAnnotation;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

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
    public void pointcut() {}

    @Before("pointcut()")
    public void process(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        log.info("方法{}开始执行，参数数量{}", methodName, method.getParameterCount());
    }
}

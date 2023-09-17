package cn.zzy.annotation;

import java.lang.annotation.*;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/17 16:11
 * @PackageName:cn.zzy.annotation
 * @ClassName: LogOnAOP
 * @Description: 加在方法签名钱，自动打印input、output
 * @Version 1.0
 */
@Target(ElementType.METHOD)  // 只能加在方法上
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LogOnAop {
    boolean enabled() default true;
}

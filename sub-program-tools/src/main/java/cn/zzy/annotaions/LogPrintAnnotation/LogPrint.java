package cn.zzy.annotaions.LogPrintAnnotation;

import java.lang.annotation.*;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/19 15:19
 * @PackageName:cn.zzy.annotaions
 * @ClassName: LogPrint
 * @Description: TODO
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogPrint {
    boolean enabled() default true;
}

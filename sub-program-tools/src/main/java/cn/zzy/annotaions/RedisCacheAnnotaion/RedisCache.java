package cn.zzy.annotaions.RedisCacheAnnotaion;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/19 16:01
 * @PackageName:cn.zzy.annotaions.RedisCacheAnnotaion
 * @ClassName: RedisCache
 * @Description: TODO
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCache {
    boolean enabled() default true;  // 默认开启

    String keyPrefix() default "redis:cache:";  //默认缓存键的前缀

    String key() default "";  //缓存键名，不要轻易赋值，默认会使用 全限定方法名 方便命中缓存

    long time() default 60;  //默认缓存60s

    TimeUnit timeunit() default TimeUnit.SECONDS;  // 默认单位秒
}

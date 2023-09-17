package cn.zzy.config;

import cn.zzy.tools.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;

import java.nio.charset.Charset;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/17 21:37
 * @PackageName:cn.zzy.config
 * @ClassName: KeyStringRedisSerializer
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class KeyStringRedisSerializer implements RedisSerializer<String> {

    private static String CACHE_PREFIX;

    private static String FILE_NAME = "redis-prefix.properties";

    static {
        // 读取配置文件的redis前缀
        PropertiesUtil propertiesUtil = new PropertiesUtil(FILE_NAME);
        CACHE_PREFIX = propertiesUtil.getProperties().getProperty("prefix");
    }

    private final Charset charset;


    public KeyStringRedisSerializer() {
        this(Charset.forName("UTF-8")); // 使用 UTF-8 字符集
    }

    public KeyStringRedisSerializer(Charset charset) {
        this.charset = charset;
    }

    @Override
    public String deserialize(@Nullable byte[] bytes) {
        return (bytes == null ? null : new String(bytes, charset).replaceFirst(CACHE_PREFIX, ""));
    }

    @Override
    public byte[] serialize(@Nullable String string) {
        return (string == null ? null : (CACHE_PREFIX + string).getBytes(charset));
    }

}

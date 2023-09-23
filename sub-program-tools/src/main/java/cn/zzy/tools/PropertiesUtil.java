package cn.zzy.tools;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/17 11:37
 * @PackageName:cn.zzy.tools
 * @ClassName: PropertiesUtil
 * @Description: 加载配置的工具类，用法是传入filename实例化，然后getProperties
 * @Version 1.0
 */
@Slf4j
public class PropertiesUtil {

    private static Properties properties = new Properties();
    private static String FILE_NAME = "default.properties";

    public Properties getProperties() {
        return properties;
    }

    public PropertiesUtil(String filename) {
        FILE_NAME = filename;
        load();
    }

    private static void load() {
        if (properties == null || properties.size() == 0) {
            PropertiesReader(FILE_NAME);  // 配置文件读进了主存中
        }
    }

    private static void PropertiesReader(String filename) {
        try (InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(filename)) {
            properties.load(resourceAsStream);
        } catch (Exception e) {
            log.warn("读取配置文件'{}'失败：{}", filename, e.getMessage());
        }
    }
}

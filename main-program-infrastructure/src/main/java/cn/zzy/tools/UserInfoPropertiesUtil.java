package cn.zzy.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/17 11:52
 * @PackageName:cn.zzy.tools
 * @ClassName: UserInfoPropertiesUtil
 * @Description: TODO
 * @Version 1.0
 */

@Slf4j
@Component
@PropertySource(value = "classpath:user-info.properties")  // 跨模块读取文件
public class UserInfoPropertiesUtil {

    private static final String FILE_NAME = "user-info.properties";

    public static volatile Map<String, String> USER_INFO = new HashMap<>();

    static {
        load();
    }

    private static void load() {
        if (USER_INFO == null || USER_INFO.size() == 0) {
            log.info("开始加载" + FILE_NAME + "配置文件");
            PropertiesUtil propertiesUtil = new PropertiesUtil(FILE_NAME);
            Properties properties = propertiesUtil.getProperties();
            Set<Object> keySet = properties.keySet();
            Iterator<Object> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                USER_INFO.put(key, properties.getProperty(key));
            }
        }
    }
}

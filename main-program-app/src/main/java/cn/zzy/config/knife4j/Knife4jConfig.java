package cn.zzy.config.knife4j;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/15 20:52
 * @PackageName:cn.zzy.config
 * @ClassName: Knife4jConfig
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
@EnableOpenApi
public class Knife4jConfig extends BaseKnife4jConfig {
    @Override
    public Knife4jProperties knife4jProperties() {
        return Knife4jProperties.builder()
                .apiBasePackage("cn.zzy")
                .title("Api接口文档")
                .description("Api接口文档")
                .contactName("zzy")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}


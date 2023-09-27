package cn.zzy.config.webMvcConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.zzy.interceptor.BaseInterceptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/27 21:28
 * @PackageName:cn.zzy.config.webMvcConfig
 * @ClassName: SpringWebMvcConfig
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
@Slf4j
public class SpringWebMvcConfig implements WebMvcConfigurer {

    @Bean
    public BaseInterceptor baseInterceptor() {
        return new BaseInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.baseInterceptor()).addPathPatterns("/**");
    }

}

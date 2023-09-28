package cn.zzy.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

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
        registry.addInterceptor(this.baseInterceptor()).addPathPatterns("/account/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加全局的 CORS 配置
        registry.addMapping("/**") // 匹配所有 URL ，相当于全局配置
            .allowedOriginPatterns("/**") // 允许所有请求来源
            .allowCredentials(true) // 允许发送 Cookie
            .allowedMethods("*") // 允许所有请求 Method
            .allowedHeaders("*") // 允许所有请求 Header
            // .exposedHeaders("*") // 允许所有响应 Header
            .maxAge(1800L); // 有效期 1800 秒，2 小时
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建 FastJsonHttpMessageConverter 对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 自定义 FastJson 配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.defaultCharset()); // 设置字符集
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect); // 剔除循环引用
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        // 设置支持的 MediaType
        fastJsonHttpMessageConverter
            .setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8));
        // 添加到 converters 中
        converters.add(0, fastJsonHttpMessageConverter); // 注意，添加到最开头，放在 MappingJackson2XmlHttpMessageConverter 前面
    }

}

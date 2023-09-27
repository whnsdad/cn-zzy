package cn.zzy.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import cn.zzy.common.Result;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/27 9:17
 * @PackageName:cn.zzy.handler
 * @ClassName: GlobalResponseHandler
 * @Description: TODO
 * @Version 1.0
 */

@ControllerAdvice(basePackages = "cn.zzy.controller")
public class GlobalResponseHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true; // 这边true时才做统一返回的包装，可以做自定义逻辑增强
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
        Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body instanceof Result<?> ? body : Result.success(202, body, "经过拦截器统一包装处理");
    }
}

package cn.zzy.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zzy.common.Result;
import cn.zzy.common.ServiceException;
import cn.zzy.enums.ServiceExpectionEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/27 10:50
 * @PackageName:cn.zzy.handler
 * @ClassName: GlobalExceptionHandler
 * @Description: TODO
 * @Version 1.0
 */
@ControllerAdvice(basePackages = "cn.zzy.controller")
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理 ServiceException 异常
     */
    @ResponseBody
    // 表示该方法的返回值将被解释为响应体，并以 JSON 格式返回给客户端。
    // 它告诉 Spring MVC 将方法的返回值序列化为 JSON，并将其作为 HTTP 响应的主体发送
    @ExceptionHandler(ServiceException.class)
    // 用于指定当出现 ServiceException 类型的异常时，将由该方法来处理。
    // 它告诉 Spring MVC 在捕获到 ServiceException 异常时调用这个方法来处理异常
    public Result serviceExceptionHandler(HttpServletRequest request, ServiceException ex) {
        log.info("触发统一异常处理器[serviceExceptionHandler]: ", ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result paramExceptionHandler(HttpServletRequest request, MissingServletRequestParameterException ex) {
        log.info("触发统一异常处理器[paramExceptionHandler]: ", ex);
        return Result.fail(ServiceExpectionEnum.PARAM_ERROR.getCode(), ServiceExpectionEnum.PARAM_ERROR.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception ex) {
        log.info("触发统一异常处理器[exceptionHandler]: ", ex);
        return Result.fail(ServiceExpectionEnum.SYSTEM_ERROR.getCode(), ServiceExpectionEnum.SYSTEM_ERROR.getMessage());
    }

}

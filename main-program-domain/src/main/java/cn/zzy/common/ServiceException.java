package cn.zzy.common;

import java.io.Serial;

import cn.zzy.enums.ServiceExpectionEnum;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/27 10:11
 * @PackageName:cn.zzy.common
 * @ClassName: ServiceException
 * @Description: TODO
 * @Version 1.0
 */
public class ServiceException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8426056524913537319L;

    private final int code;

    public ServiceException(ServiceExpectionEnum serviceExpectionEnum) {
        super(serviceExpectionEnum.getMessage());
        this.code = serviceExpectionEnum.getCode();
    }

    public int getCode() {
        return this.code;
    }
}

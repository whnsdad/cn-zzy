package cn.zzy.commonDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/17 11:02
 * @PackageName:cn.zzy.commonDomain
 * @ClassName: Result
 * @Description: TODO
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 3755946767012318235L;

    private Integer code;

    private String message;

    private T data;

    // 用于@RedisCache的时候把缓存中的String还原为Result
    public static <T> Result<T> fromString() {
        return new Result<>();
    }

    // 静态成功方法及重载
    public static <T> Result<T> success() {
        return new Result<>(200, "success", null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<>(200, message, data);
    }

    // 静态失败方法及重载
    public static <T> Result<T> fail() {
        return new Result<>(404, "fail", null);
    }

    public static <T> Result<T> fail(Integer code) {
        return new Result<>(code, "fail", null);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }


}

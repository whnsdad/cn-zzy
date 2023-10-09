package cn.zzy.dto.login;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/30 19:54
 * @PackageName:cn.zzy.dto.login
 * @ClassName: LoginVO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("登陆响应体")
public class LoginVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7247457966793450239L;

    private Boolean success;

    private String token;
}

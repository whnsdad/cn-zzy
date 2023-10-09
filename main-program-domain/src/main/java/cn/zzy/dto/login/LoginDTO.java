package cn.zzy.dto.login;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/30 19:55
 * @PackageName:cn.zzy.dto.login
 * @ClassName: LoginDTO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("登陆请求体")
public class LoginDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8264390806531371209L;

    private String username;

    private String password;
}

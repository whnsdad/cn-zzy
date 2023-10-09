package cn.zzy.dos.rbac;

import java.io.Serial;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/28 14:58
 * @PackageName:cn.zzy.dos
 * @ClassName: UserRoleDO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_user_role")
@ApiModel("用户角色关联表")
public class UserRoleDO implements Serializable {
    @Serial
    private static final long serialVersionUID = -28339311731774144L;

    @TableId("user_id")
    @ApiModelProperty(name = "用户ID")
    private Long userId;

    @TableField("role_id")
    @ApiModelProperty(name = "角色ID")
    private Long roleId;
}

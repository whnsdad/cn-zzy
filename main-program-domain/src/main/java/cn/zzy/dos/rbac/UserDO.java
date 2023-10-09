package cn.zzy.dos.rbac;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/28 14:36
 * @PackageName:cn.zzy.dos
 * @ClassName: UserDO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel("用户信息")
public class UserDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4887052672847022031L;

    @TableId("user_id")
    @ApiModelProperty(name = "用户ID")
    private Long userId;

    @TableField("dept_id")
    @ApiModelProperty(name = "部门编号")
    private Long deptId;

    @TableField("user_name")
    @ApiModelProperty(name = "用户账号")
    private String userName;

    @TableField("nick_name")
    @ApiModelProperty(name = "用户昵称")
    private String nickName;

    @TableField("user_type")
    @ApiModelProperty(name = "用户类型")
    private String userType; // 00系统用户

    @TableField("email")
    @ApiModelProperty(name = "用户邮箱")
    private String email;

    @TableField("phone")
    @ApiModelProperty(name = "手机号码")
    private String phone;

    @TableField("gender")
    @ApiModelProperty(name = "用户性别")
    private String gender;

    @TableField("avatar")
    @ApiModelProperty(name = "用户头像")
    private String avatar;

    @TableField("password")
    @ApiModelProperty(name = "密码")
    private String password;

    @TableField("status")
    @ApiModelProperty(name = "帐号状态")
    private String status; // 帐号状态（0正常 1停用）

    @TableField("del_flag")
    @ApiModelProperty(name = "删除标志")
    private String delFlag; // 删除标志（0代表存在 2代表删除）

    @TableField("login_ip")
    @ApiModelProperty(name = "最后登录IP")
    private String loginIp;

    @TableField("login_date")
    @ApiModelProperty(name = "最后登录时间")
    private Date loginDate;

    @TableField("create_by")
    @ApiModelProperty(name = "创建者")
    private String createBy;

    @TableField("create_time")
    @ApiModelProperty(name = "创建时间")
    private Date createTime;

    @TableField("update_by")
    @ApiModelProperty(name = "更新者")
    private String updateBy;

    @TableField("update_time")
    @ApiModelProperty(name = "更新时间")
    private Date updateTime;

}

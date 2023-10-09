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
 * @Date 2023/9/28 15:44
 * @PackageName:cn.zzy.dos.rbac
 * @ClassName: LoginInfoDO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_login_info")
@ApiModel("登录日志")
public class LoginInfoDO implements Serializable {
    @Serial
    private static final long serialVersionUID = -5645526819043543043L;

    @TableId("info_id")
    @ApiModelProperty(name = "记录ID")
    private Long infoId;

    @TableField("user_name")
    @ApiModelProperty(name = "用户账号")
    private String userName;

    @TableField("ipaddr")
    @ApiModelProperty(name = "登录ip地址")
    private String ipaddr;

    @TableField("login_location")
    @ApiModelProperty(name = "登录地点")
    private String loginLocation;

    @TableField("browser")
    @ApiModelProperty(name = "浏览器类型")
    private String browser;

    @TableField("os")
    @ApiModelProperty(name = "操作系统")
    private String os;

    @TableField("status")
    @ApiModelProperty(name = "登录状态")
    private String status;

    @TableField("msg")
    @ApiModelProperty(name = "提示消息")
    private String msg;

    @TableField("login_time")
    @ApiModelProperty(name = "访问时间")
    private Date loginTime;
}

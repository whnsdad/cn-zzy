package cn.zzy.dos;

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
 * @Date 2023/9/28 14:52
 * @PackageName:cn.zzy.dos
 * @ClassName: RoleDO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_role")
@ApiModel("角色信息")
public class RoleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("role_id")
    @ApiModelProperty(name = "角色ID")
    private Long roleId;

    @TableField("role_name")
    @ApiModelProperty(name = "角色名称")
    private String roleName;

    @TableField("role_key")
    @ApiModelProperty(name = "角色权限字符串")
    private String roleKey;

    @TableField("role_sort")
    @ApiModelProperty(name = "显示顺序")
    private String roleSort;

    @TableField("data_scope")
    @ApiModelProperty(name = "数据范围")
    // 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
    private String dataScope;

    @TableField("status")
    @ApiModelProperty(name = "角色状态")
    // 0=正常,1=停用
    private String status;

    @TableField("del_flag")
    @ApiModelProperty("删除标志")
    // 删除标志（0代表存在 2代表删除）
    private String delFlag;

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

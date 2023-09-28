package cn.zzy.dos;

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
 * @Date 2023/9/28 15:09
 * @PackageName:cn.zzy.dos
 * @ClassName: RoleMenuDO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@TableName("sys_role_menu")
@ApiModel("角色菜单关联表")
public class RoleMenuDO implements Serializable {
    @Serial
    private static final long serialVersionUID = -668183580679638770L;

    @TableId("role_id")
    @ApiModelProperty(name = "角色ID")
    private Long roleId;

    @TableField("menu_id")
    @ApiModelProperty(name = "菜单ID")
    private Long menuId;
}

package cn.zzy.dos.rbac;

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
 * @Date 2023/9/16 12:20
 * @PackageName:cn.zzy.DO
 * @ClassName: MenuDO
 * @Description: TODO
 * @Version 1.0
 */

@Data
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel("菜单信息")
public class MenuDO {

    @TableId("menu_id")
    @ApiModelProperty(name = "菜单ID")
    private Long menuId;

    @TableField("menu_name")
    @ApiModelProperty(name = "菜单名称")
    private String menuName;

    @TableField("parent_id")
    @ApiModelProperty(name = "父菜单ID")
    private Long parentId;

    @TableField("order_num")
    @ApiModelProperty(name = "显示顺序")
    private String orderNum;

    @TableField("path")
    @ApiModelProperty(name = "路由地址")
    private String path;

    @TableField("component")
    @ApiModelProperty(name = "组件路径")
    private String component;

    @TableField("is_frame")
    @ApiModelProperty(name = "是否为外链")
    // 是否为外链（0是 1否）
    private String isFrame;

    @TableField("menu_type")
    @ApiModelProperty(name = "类型")
    // 菜单类型（M目录 C菜单 F按钮）
    private String menuType;

    @TableField("visible")
    @ApiModelProperty(name = "菜单状态")
    // 0显示,1隐藏
    private String visible;

    @TableField("perms")
    @ApiModelProperty(name = "权限标识、字符串")
    // 0显示,1隐藏
    private String perms;

    @TableField("icon")
    @ApiModelProperty(name = "菜单图标")
    // 菜单图标
    private String icon;

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

    @TableField("remark")
    @ApiModelProperty(name = "备注")
    private String remark;

}

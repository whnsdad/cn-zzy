package cn.zzy.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("menu_tree")
public class MenuDO {

    @TableId("id")
    private String id;
    @TableField("name")
    private String name;
    @TableField("parent_id")
    private String parentId;
    @TableField("level")
    private int level;
    @TableField("create_user")
    private String createUser;
    @TableField("update_user")
    private String updateUser;

}

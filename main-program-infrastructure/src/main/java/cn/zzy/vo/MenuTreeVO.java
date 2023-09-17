package cn.zzy.vo;

import cn.zzy.DO.MenuDO;
import cn.zzy.menuTreeTools.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/16 13:02
 * @PackageName:cn.zzy.VO
 * @ClassName: MenuTreeVO
 * @Description: TODO
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@ToString(callSuper = true)  // 这样打印子类会带出父类属性
public class MenuTreeVO extends TreeNode implements Serializable {

    @Serial
    private static final long serialVersionUID = -3059173159152518558L;
    private String name;
    private int level;
    private String createUser;
    private String updateUser;

    public static MenuTreeVO to(MenuDO menuDO) {
        return (MenuTreeVO) new MenuTreeVO()
                .setName(menuDO.getName())
                .setLevel(menuDO.getLevel())
                .setCreateUser(menuDO.getCreateUser())
                .setUpdateUser(menuDO.getUpdateUser())
                .setId(menuDO.getId())
                .setParentId(menuDO.getParentId());
    }
}

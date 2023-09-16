package cn.zzy.menuTreeTools;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/16 12:35
 * @PackageName:cn.zzy.menuTreeTools
 * @ClassName: TreeNode
 * @Description: TODO
 * @Version 1.0
 */

@Data
@Accessors(chain = true)
public class TreeNode {

    /**
     * 编号
     */
    private String id;

    /**
     * 上级编号
     */
    private String parentId;

    /**
     * 下级节点列表
     */
    private List<TreeNode> children = new ArrayList<>();
}

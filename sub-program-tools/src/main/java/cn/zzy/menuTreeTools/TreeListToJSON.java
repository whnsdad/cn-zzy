package cn.zzy.menuTreeTools;

import java.util.List;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/17 10:35
 * @PackageName:cn.zzy.menuTreeTools
 * @ClassName: TreeListToJSON
 * @Description: 树形list转树形JSON，入参必须继承TreeNode类
 * @Version 1.0
 */
public class TreeListToJSON {
    public static <T extends TreeNode> String convertTreeToJson(List<T> nodes) {
        StringBuilder json = new StringBuilder("[");
        for (TreeNode node : nodes) {
            json.append("{")
                    .append("\"id\":").append(node.getId()).append(",")
                    .append("\"parentId\":").append(node.getParentId()).append(",")
                    .append("\"children\":").append(convertTreeToJson(node.getChildren()))
                    .append("},");
        }
        if (!nodes.isEmpty()) {
            json.deleteCharAt(json.length() - 1); // 移除最后一个逗号
        }
        json.append("]");
        return json.toString();
    }
}

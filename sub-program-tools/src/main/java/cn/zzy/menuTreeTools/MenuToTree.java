package cn.zzy.menuTreeTools;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/16 12:38
 * @PackageName:cn.zzy.menuTreeTools
 * @ClassName: MenuToTree
 * @Description: TODO
 * @Version 1.0
 */

@Slf4j
public class MenuToTree {

    /**
     * 扁平数据转树结构
     *
     * @param nodes
     * @param <T>
     * @return
     */
    public static <T extends TreeNode> List<T> convert(List<T> nodes) {
        if (CollectionUtils.isEmpty(nodes)) {
            return Lists.newArrayList();
        }

        List<T> nodeTree = new ArrayList<>();
        Map<String, T> nodeMap = new HashMap<>(nodes.size());  // key是菜单id，T是菜单实例
        Class<T> clazz = (Class<T>) nodes.get(0).getClass();        // (2)
        for (T t : nodes) {
            t.getChildren().addAll(nodeMap.containsKey(t.getId())
                    ? nodeMap.get(t.getId()).getChildren()
                    : new ArrayList<>());// (3)
            nodeMap.put(t.getId(), t);  // (4)

            if (null == t.getParentId() || "0".equals(t.getParentId())) {  // 只有根菜单的parentId才会是0
                nodeTree.add(t);  // 根菜单直接往list放
            } else {
                if (!nodeMap.containsKey(t.getParentId())) {  // (6)
                    T instance = null;
                    try {
                        instance = clazz.newInstance();
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                    nodeMap.put(t.getParentId(), instance);
                }
                nodeMap.get(t.getParentId()).getChildren().add(t);
            }
        }
        return nodeTree;
    }
}

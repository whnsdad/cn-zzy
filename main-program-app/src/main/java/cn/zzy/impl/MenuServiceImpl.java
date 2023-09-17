package cn.zzy.impl;

import cn.zzy.DO.MenuDO;
import cn.zzy.mapper.MenuMapper;
import cn.zzy.menuTreeTools.MenuToTree;
import cn.zzy.menuTreeTools.TreeListToJSON;
import cn.zzy.service.MenuService;
import cn.zzy.tools.UserInfoPropertiesUtil;
import cn.zzy.vo.MenuTreeVO;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDO> implements MenuService {
    @Override
    public JSONArray getAllMenusTree() {

        log.info("当前操作用户：" + UserInfoPropertiesUtil.USER_INFO.get("username"));
        List<MenuDO> menuDOList = list();
        List<MenuTreeVO> menuVOList = menuDOList.stream().map(MenuTreeVO::to).collect(Collectors.toList());  // DO转VO
        List<MenuTreeVO> convert = MenuToTree.convert(menuVOList);
        String s = TreeListToJSON.convertTreeToJson(convert);
//        log.info("树形list菜单结果：{}", s);
        return JSON.parseArray(s);
    }
}

package cn.zzy.impl;

import cn.zzy.DO.MenuDO;
import cn.zzy.VO.MenuTreeVO;
import cn.zzy.mapper.MenuMapper;
import cn.zzy.menuTreeTools.MenuToTree;
import cn.zzy.menuTreeTools.TreeListToJSON;
import cn.zzy.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDO> implements MenuService {
    @Override
    public void getAllMenus() {
        List<MenuDO> menuDOList = list();
        List<MenuTreeVO> menuVOList = menuDOList.stream().map(MenuTreeVO::to).collect(Collectors.toList());  // DO转VO
        List<MenuTreeVO> convert = MenuToTree.convert(menuVOList);
        convert.forEach(System.out::println);

        String treeJSON = TreeListToJSON.convertTreeToJson(convert);
        System.out.println(treeJSON);


    }
}

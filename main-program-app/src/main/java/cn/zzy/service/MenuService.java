package cn.zzy.service;

import cn.zzy.DO.MenuDO;
import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;

public interface MenuService extends IService<MenuDO> {

    JSONArray getAllMenusTree();
}

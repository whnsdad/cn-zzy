package cn.zzy.service;

import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.zzy.dos.MenuDO;

public interface MenuService extends IService<MenuDO> {

    JSONArray getAllMenusTree();

    void insertA();
}

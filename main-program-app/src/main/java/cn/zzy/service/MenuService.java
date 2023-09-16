package cn.zzy.service;

import cn.zzy.DO.MenuDO;
import com.baomidou.mybatisplus.extension.service.IService;

public interface MenuService extends IService<MenuDO> {

    void getAllMenus();
}

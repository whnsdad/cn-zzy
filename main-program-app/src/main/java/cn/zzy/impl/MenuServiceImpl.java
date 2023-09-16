package cn.zzy.impl;

import cn.zzy.DO.MenuDO;
import cn.zzy.mapper.MenuMapper;
import cn.zzy.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDO> implements MenuService {
    @Override
    public void getAllMenus() {
        list().forEach(System.out::println);
    }
}

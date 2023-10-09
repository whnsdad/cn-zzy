package cn.zzy.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.zzy.dos.rbac.MenuDO;
import cn.zzy.mapper.MenuMapper;
import cn.zzy.service.MenuService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDO> implements MenuService {

}

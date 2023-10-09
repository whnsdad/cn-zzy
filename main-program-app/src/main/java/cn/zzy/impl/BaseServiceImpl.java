package cn.zzy.impl;

import org.springframework.stereotype.Service;

import cn.zzy.dto.login.LoginDTO;
import cn.zzy.dto.login.LoginVO;
import cn.zzy.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/30 19:59
 * @PackageName:cn.zzy.impl
 * @ClassName: BaseServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
@Slf4j
public class BaseServiceImpl implements BaseService {
    @Override
    public LoginVO login(LoginDTO loginDTO) {
        return null;
    }
}

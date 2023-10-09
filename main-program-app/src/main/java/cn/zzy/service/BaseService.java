package cn.zzy.service;

import cn.zzy.dto.login.LoginDTO;
import cn.zzy.dto.login.LoginVO;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/30 19:56
 * @PackageName:cn.zzy.service
 * @ClassName: BaseService
 * @Description: TODO
 * @Version 1.0
 */
public interface BaseService {

    LoginVO login(LoginDTO loginDTO);
}

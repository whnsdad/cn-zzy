package cn.zzy.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzy.common.Result;
import cn.zzy.common.ServiceException;
import cn.zzy.dto.login.LoginDTO;
import cn.zzy.dto.login.LoginVO;
import cn.zzy.enums.ServiceExpectionEnum;
import cn.zzy.service.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/base")
@RestController
@Api(tags = "基础模块")
@Slf4j
public class BaseController {

    @Autowired
    private BaseService baseService;

    @PostMapping("/test/exception1")
    @ApiOperation("测试异常捕获1")
    public void test1() {
        throw new NullPointerException();
    }

    @PostMapping("/test/exception2")
    @ApiOperation("测试异常捕获2")
    public void test2() {
        throw new ServiceException(ServiceExpectionEnum.USER_NOT_FOUND);
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public Result<LoginVO> login(LoginDTO loginDTO) {
        LoginVO login = baseService.login(loginDTO);
        return login.getSuccess() ? Result.success(login) : Result.fail(404, "登陆失败");
    }
}

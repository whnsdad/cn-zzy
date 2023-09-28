package cn.zzy.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzy.common.Result;
import cn.zzy.dto.account.DepositDTO;
import cn.zzy.impl.AccountServiceImpl;
import cn.zzy.proxy.AccountProxy;
import cn.zzy.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 10:33
 * @PackageName:cn.zzy
 * @ClassName: AccountController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/account")
@Slf4j
@Api(tags = "转账服务")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/deposit")
    @ApiOperation("转账操作")
    public Result<Boolean> deposit(@RequestBody DepositDTO depositDTO) {
        try {
            Boolean deposit = accountService.deposit(depositDTO);
        } catch (Exception e) {
            log.info(e.getMessage());
            return Result.fail(500, e.getMessage());
        }
        return Result.success("转账成功");
    }

    @PostMapping("/deposit2")
    @ApiOperation("转账操作-测试动态代理")
    public Result<Boolean> deposit2(@RequestBody DepositDTO depositDTO) {
        AccountServiceImpl accountService1 = new AccountServiceImpl();
        AccountProxy accountProxy = new AccountProxy();
        AccountService proxy = (AccountService)accountProxy.getProxy(accountService1);
        try {
            Boolean deposit = proxy.deposit2(depositDTO);
        } catch (Exception e) {
            log.warn(e.getMessage());
            return Result.fail(500, e.getMessage());
        }
        return Result.success();
    }

}

package cn.zzy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzy.commonDomain.Result;
import cn.zzy.dto.account.DepositDTO;
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

        return accountService.deposit(depositDTO) ? Result.success() : Result.fail();
    }

}

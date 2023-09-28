package cn.zzy.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.zzy.dos.AccountDO;
import cn.zzy.dto.account.DepositDTO;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 10:50
 * @PackageName:cn.zzy.service
 * @ClassName: AccountService
 * @Description: TODO
 * @Version 1.0
 */
public interface AccountService extends IService<AccountDO> {

    Boolean deposit(DepositDTO depositDTO);
}

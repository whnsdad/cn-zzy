package cn.zzy.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.zzy.DO.AccountDO;
import cn.zzy.DO.DepositRecordDO;
import cn.zzy.dto.account.DepositDTO;
import cn.zzy.mapper.AccountMapper;
import cn.zzy.service.AccountService;
import cn.zzy.service.DepositService;
import cn.zzy.tools.IdGeneratorSnowFlake;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 10:51
 * @PackageName:cn.zzy.impl
 * @ClassName: DepositServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountDO> implements AccountService {

    @Autowired
    private DepositService depositService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deposit(DepositDTO depositDTO) {
        BigDecimal amount = depositDTO.getAmount();
        try {
            // 转出
            AccountDO accountDO1 = getById(depositDTO.getUserId());
            if (amount.compareTo(accountDO1.getMoney()) > 0) {
                log.info("转账金额{}超过用户账户金额{}", amount, accountDO1.getMoney());
                throw new Exception("转账金额超过用户账户金额");
            }
            boolean out = updateById(accountDO1.setMoney(accountDO1.getMoney().subtract(amount)));
            if (!out) {
                log.info("用户{}转账过程发生错误", depositDTO.getUserId());
                throw new Exception("转账过程1发生错误");
            }

            // 转入
            AccountDO accountDO2 = getById(depositDTO.getToId());
            boolean in = updateById(accountDO2.setMoney(accountDO2.getMoney().add(amount)));
            if (!in) {
                log.info("转入用户{}过程发生错误", depositDTO.getToId());
                throw new Exception("转账过程2发生错误");
            }

            // 生成转账记录，入库
            DepositRecordDO depositRecordDO = new DepositRecordDO().setId(new IdGeneratorSnowFlake().snowflakeId())
                .setAmount(amount).setTime(depositDTO.getOperationTime()).setMessage(depositDTO.getMessage())
                .setOperation(depositDTO.getOperation()).setUserFromId(depositDTO.getUserId())
                .setUserToId(depositDTO.getToId());
            Boolean saveRecord = depositService.saveDepositRecord(depositRecordDO);
            if (!saveRecord) {
                log.info("保存转账记录发生错误：{}", depositRecordDO);
                throw new Exception("保存转账记录发生错误");
            }
        } catch (Exception e) {
            log.info("出现异常：{}，触发回滚", e.getMessage());
            throw new RuntimeException("出现异常，触发回滚");
        }
        return Boolean.TRUE;
    }

}

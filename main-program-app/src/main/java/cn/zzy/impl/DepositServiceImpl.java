package cn.zzy.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.zzy.DO.DepositRecordDO;
import cn.zzy.mapper.DepositMapper;
import cn.zzy.service.DepositService;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 11:57
 * @PackageName:cn.zzy.impl
 * @ClassName: DepositServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class DepositServiceImpl extends ServiceImpl<DepositMapper, DepositRecordDO> implements DepositService {

    @Override
    public Boolean saveDepositRecord(DepositRecordDO depositRecordDO) {
        return save(depositRecordDO);
    }
}

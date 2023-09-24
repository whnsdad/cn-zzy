package cn.zzy.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.zzy.DO.DepositRecordDO;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 11:57
 * @PackageName:cn.zzy.service
 * @ClassName: DepositService
 * @Description: TODO
 * @Version 1.0
 */
public interface DepositService extends IService<DepositRecordDO> {

    Boolean saveDepositRecord(DepositRecordDO depositRecordDO);
}

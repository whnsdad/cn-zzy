package cn.zzy.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.zzy.dos.DepositRecordDO;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 11:58
 * @PackageName:cn.zzy.mapper
 * @ClassName: DepositMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface DepositMapper extends BaseMapper<DepositRecordDO> {}

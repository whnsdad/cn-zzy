package cn.zzy.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.zzy.dos.AccountDO;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 11:03
 * @PackageName:cn.zzy.mapper
 * @ClassName: AccountMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {}

package cn.zzy.mapper;

import cn.zzy.DO.AccountDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 11:03
 * @PackageName:cn.zzy.mapper
 * @ClassName: AccountMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {
}

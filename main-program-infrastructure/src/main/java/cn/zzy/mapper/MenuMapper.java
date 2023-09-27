package cn.zzy.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.zzy.dos.MenuDO;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/16 12:19
 * @PackageName:cn.zzy.mapper
 * @ClassName: MenuMapper
 * @Description: TODO
 * @Version 1.0
 */

@Mapper
public interface MenuMapper extends BaseMapper<MenuDO> {

}

package cn.zzy.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 10:29
 * @PackageName:cn.zzy.DO
 * @ClassName: AccountDO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@TableName("account")
public class AccountDO {

    @TableId("id")
    private String id;
    @TableField("username")
    private String userName;
    @TableField("money")
    private BigDecimal money;
}

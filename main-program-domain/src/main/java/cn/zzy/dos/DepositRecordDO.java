package cn.zzy.dos;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.zzy.enums.DepositOperation;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 11:41
 * @PackageName:cn.zzy.DO
 * @ClassName: DepositRecordDO
 * @Description: TODO
 * @Version 1.0
 */

@Data
@Accessors(chain = true)
@TableName("deposit_record")
public class DepositRecordDO {
    @TableId("id")
    private String id;
    @TableField("user_id_from")
    private String userFromId;
    @TableField("user_id_to")
    private String userToId;
    @TableField("amount")
    private BigDecimal amount;
    @TableField("description")
    private DepositOperation operation;
    @TableField("message")
    private String message;
    @TableField("operation_time")
    private String time;

}

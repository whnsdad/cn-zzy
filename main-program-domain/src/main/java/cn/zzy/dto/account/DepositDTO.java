package cn.zzy.dto.account;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;

import cn.zzy.enums.DepositOperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/23 10:34
 * @PackageName:cn.zzy.dto.account
 * @ClassName: DepositDTO
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("转账请求DTO")
public class DepositDTO {

    @NotBlank(message = "用户id不能为空")
    @ApiModelProperty("转出用户id")
    private String userId;

    @NotBlank(message = "接收转账的用户不能为空")
    @ApiModelProperty("转入用户id")
    private String toId;

    @NotBlank(message = "转账金额不能为空")
    @DecimalMax(message = "超过单笔转账限度", value = "20000")
    @ApiModelProperty("转账金额")
    private BigDecimal amount;

    @ApiModelProperty("转账时间")
    private String operationTime;

    @ApiModelProperty("转账原因枚举类")
    private DepositOperation operation;

    @ApiModelProperty("转账附带信息")
    private String message;
}

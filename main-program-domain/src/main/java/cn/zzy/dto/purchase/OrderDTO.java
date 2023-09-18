package cn.zzy.dto.purchase;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/18 21:14
 * @PackageName:cn.zzy.dto.purchase
 * @ClassName: OrderDTO
 * @Description: TODO
 * @Version 1.0
 */

@Data
@Accessors(chain = true)
public class OrderDTO {
    // 商品id
    private String productId;
    // 抢购数量
    private Long num;
    // 用户id
    private String userId;
    // 下单时间
    private String orderTime;
    
}

package cn.zzy.service;

import cn.zzy.dto.purchase.OrderDTO;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/18 21:12
 * @PackageName:cn.zzy.service
 * @ClassName: PurchaseService
 * @Description: TODO
 * @Version 1.0
 */
public interface PurchaseService {

    Boolean order(OrderDTO orderDTO);
}

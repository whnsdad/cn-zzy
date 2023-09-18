package cn.zzy.impl;

import cn.zzy.dto.purchase.OrderDTO;
import cn.zzy.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/18 21:17
 * @PackageName:cn.zzy.impl
 * @ClassName: PurchaseServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {
    @Override
    public Boolean order(OrderDTO orderDTO) {
        return null;
    }
}

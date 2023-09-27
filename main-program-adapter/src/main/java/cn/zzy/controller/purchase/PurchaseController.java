package cn.zzy.controller.purchase;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzy.common.Result;
import cn.zzy.dto.purchase.OrderDTO;
import cn.zzy.service.PurchaseService;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/18 21:10
 * @PackageName:cn.zzy.purchase
 * @ClassName: PurchaseController
 * @Description: 抢购系统接口，主要联系锁机制
 * @Version 1.0
 */

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Resource
    private PurchaseService purchaseService;

    @PostMapping("/order")
    public Result<Boolean> order(@RequestBody OrderDTO orderDTO) {
        return purchaseService.order(orderDTO) ? Result.success() : Result.fail();
    }
}

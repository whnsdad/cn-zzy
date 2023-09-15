package cn.zzy.menuController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@Slf4j
@Api(tags = "菜单接口")
public class MenuController {

    @PostMapping("/list")
    @ApiOperation("查询所有菜单")
    public void getAllMenus() {
        log.info("接口暴露成功");
    }
}

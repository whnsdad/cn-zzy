package cn.zzy.controller.menu;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzy.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/menu")
@Slf4j
@Api(tags = "菜单接口")
public class MenuController {

    @Resource
    private MenuService menuService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

    @PostMapping("/test")
    @ApiOperation("测试redis")
    public void test() {
        redisTemplate.opsForValue().set("key1", "value1");
    }

}

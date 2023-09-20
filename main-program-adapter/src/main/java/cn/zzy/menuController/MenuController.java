package cn.zzy.menuController;

import cn.zzy.annotaions.LogPrintAnnotation.LogPrint;
import cn.zzy.commonDomain.Result;
import cn.zzy.service.MenuService;
import com.alibaba.fastjson2.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/menu")
@Slf4j
@Api(tags = "菜单接口")
public class MenuController {

    @Resource
    private MenuService menuService;

    @PostMapping("/list")
    @ApiOperation("查询所有菜单(按树形返回)")
    @LogPrint
    public Result<JSONArray> getAllMenusTree() {
        return Result.success(menuService.getAllMenusTree());
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

    @PostMapping("/test")
    @ApiOperation("测试redis")
    public void test() {
        redisTemplate.opsForValue().set("key1", "value1");
    }

    @PostMapping("/transac")
    @ApiOperation("测试事务")
    public void testTransactional() {
        try {
            menuService.insertA();
        } catch (Exception e) {
            log.info("exception");
        }
    }

}


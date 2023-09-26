package cn.zzy.designPatternController;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zzy.service.DesignPatternService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/26 9:14
 * @PackageName:cn.zzy
 * @ClassName: designPatternController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/pattern")
@Api(tags = "联系设计模式")
public class DesignPatternController {

    @Resource
    private DesignPatternService designPatternService;

    @GetMapping("/test/{type}")
    @ApiOperation("测试设计模式")
    public void test(@PathVariable("type") String type) {
        String test = designPatternService.test(type);
        System.out.println(test);
    }

}

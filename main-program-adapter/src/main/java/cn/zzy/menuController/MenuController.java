package cn.zzy.menuController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    @PostMapping("/list")
    public void getAllMenus(){
        log.info("接口暴露成功");
    }
}

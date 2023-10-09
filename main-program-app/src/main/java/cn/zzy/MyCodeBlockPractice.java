package cn.zzy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/10/9 10:23
 * @PackageName:cn.zzy
 * @ClassName: MyCodeBlockPractice
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class MyCodeBlockPractice {
    static {
        log.info("[static code block]");
    }

    {
        log.info("[non-static code block]");
    }

    public MyCodeBlockPractice() {
        log.info("[non-arg constructor]");
    }
}

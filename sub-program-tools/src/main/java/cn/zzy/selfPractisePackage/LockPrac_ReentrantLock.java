package cn.zzy.selfPractisePackage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/19 14:36
 * @PackageName:cn.zzy.selfPractisePackage
 * @ClassName: LockPrac_ReentrantLock
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class LockPrac_ReentrantLock {

    private static int res = 0;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        while (res < 1000) {
            Thread thread = new Thread(() -> {
                res = counter.increment(res);
            });
            thread.start();
            thread.join();  // 主线程阻塞以让thread以及开始执行
        }

        System.out.println("res: " + res);
    }


}

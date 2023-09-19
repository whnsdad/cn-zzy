package cn.zzy.selfPractisePackage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/18 21:21
 * @PackageName:cn.zzy.selfPractisePackage
 * @ClassName: LockPrac
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class LockPrac_synchronized {

    private static volatile int res = 10; //库存

    private final Object lock = new Object();

    public static void main(String[] args) {
        LockPrac_synchronized lockPrac = new LockPrac_synchronized();
        int threadIndex = 0;
        while (res > 0) {
            lockPrac.purchase("thread" + threadIndex);
            threadIndex++;
        }
    }

    private void purchase(String threadName) {
        Thread thread = new Thread(() -> {
            if (res > 0) {
                synchronized (lock) {
                    if (res > 0) {
                        res--;
                        log.info("线程{}抢购了一个商品，目前库存：{}", threadName, res);
                    }
                }
            }

        });
        thread.setName(threadName);
        thread.start();
    }
}

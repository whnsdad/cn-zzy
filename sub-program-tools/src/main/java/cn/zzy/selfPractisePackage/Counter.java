package cn.zzy.selfPractisePackage;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/19 14:44
 * @PackageName:cn.zzy.selfPractisePackage
 * @ClassName: Conter
 * @Description: TODO
 * @Version 1.0
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private static Lock lock = new ReentrantLock();

    public int increment(int res) {
        lock.lock();
        try {
            res++;
            System.out.println(Thread.currentThread().getName() + "将res+1，目前值为" + res);
        } finally {
            lock.unlock();
        }
        return res;
    }

    public int getCount() {
        return count;
    }
}


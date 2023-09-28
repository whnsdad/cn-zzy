package cn.zzy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/28 9:50
 * @PackageName:cn.zzy.proxy
 * @ClassName: AccountProxy
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
public class AccountProxy implements InvocationHandler {

    // 被代理的类
    public Object object;

    // 得到代理示例
    public Object getProxy(Object object) {
        this.object = object;
        // 通过Proxy.newProxyInstance方法创建一个代理对象 即得到代理类
        // 3个参数为 要代理的对象的类加载器、接口、及实现了InvocationHandler接口的类,一般即自身
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("[AccountProxy]前置生效");
        Object result = method.invoke(object, args);
        log.info("[AccountProxy]后置生效");
        return result;
    }
}

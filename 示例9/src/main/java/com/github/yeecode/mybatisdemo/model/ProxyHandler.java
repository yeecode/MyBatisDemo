package com.github.yeecode.mybatisdemo.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler<T> implements InvocationHandler {
    private T target;

    public ProxyHandler(T target) {
        this.target = target;
    }

    /**
     * @param proxy  被代理的对象
     * @param method 要调用的方法
     * @param args   方法调用时所需要参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre words");
        Object ans = method.invoke(target, args);
        System.out.println("post words");
        return ans;
    }
}
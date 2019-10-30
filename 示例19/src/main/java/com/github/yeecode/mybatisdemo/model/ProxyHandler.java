package com.github.yeecode.mybatisdemo.model;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler<T> implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before speak");
        Object ans = methodProxy.invokeSuper(o, objects);
        System.out.println("after speak");
        return ans;
    }
}
package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.ProxyHandler;
import com.github.yeecode.mybatisdemo.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws Exception {
        Enhancer enhancer = new Enhancer();
        // 设置enhancer的回调对象
        enhancer.setCallback(new ProxyHandler<>());
        // 设置enhancer对象的父类
        enhancer.setSuperclass(User.class);
        // 创建代理对象，实际为User的子类
        User user = (User) enhancer.create();

        // 通过代理对象调用目标方法
        String ans = user.sayHello("易哥");
        System.out.println(ans);
    }
}

package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.UserProxy;
import com.github.yeecode.mybatisdemo.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws Exception {
        // 生成被代理对象
        User user = new User();

        // 生成代理，顺便告诉代理它要代理谁
        UserProxy userProxy = new UserProxy(user);

        // 触发代理方法
        userProxy.sayHello("易哥");
    }
}

package com.github.yeecode.mybatisdemo;

import org.apache.ibatis.reflection.TypeParameterResolver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Type;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        try {
            // 使用TypeParameterResolver分析User类中getInfo方法输出结果的具体类型
            Type type1 = TypeParameterResolver.resolveReturnType(User.class.getMethod("getInfo"), User.class);
            System.out.println("User类中getInfo方法的输出结果类型 :\n" + type1);

            // 使用TypeParameterResolver分析Student类中getInfo方法输出结果的具体类型
            Type type2 = TypeParameterResolver.resolveReturnType(User.class.getMethod("getInfo"), Student.class);
            System.out.println("Student类中getInfo方法的输出结果类型 :\n" + type2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

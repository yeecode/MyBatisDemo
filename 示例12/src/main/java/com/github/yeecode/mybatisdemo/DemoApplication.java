package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.builder.GardenSchoolUserBuilder;
import com.github.yeecode.mybatisdemo.builder.SunnySchoolUserBuilder;
import com.github.yeecode.mybatisdemo.builder.UserBuilder;
import com.github.yeecode.mybatisdemo.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        // 第一种：先创建对象在设置属性的方式建造对象
        User user01 = new User();
        user01.setName("Candy");
        user01.setEmail("candy@sunnyschool.com");
        user01.setAge(7);
        user01.setSex(1);
        user01.setSchoolName("Sunny School");
        // 第二种：用构造方法建造对象
        User user02 = new User("Candy", "candy@sunnyschool.com", 7, 1, "Sunny School");

        // 第三种：用建造者建造对象

        // 3.1 用匿名建造者建造一个对象
        User user03 = new SunnySchoolUserBuilder("Candy").setSex(1).build();

        // 3.2 分步设置建造者属性，建造一个对象
        UserBuilder userBuilder04 = new SunnySchoolUserBuilder("Eric");
        userBuilder04.setEmail("supereric@abc.com").build();
        User user04 = userBuilder04.build();

        System.out.println(user01);
        System.out.println(user02);
        System.out.println(user03);
        System.out.println(user04);

    }
}



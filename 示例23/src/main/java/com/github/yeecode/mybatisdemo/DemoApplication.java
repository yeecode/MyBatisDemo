package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            User user01 = new User("张大壮","dazhuang@sample.mail",18, 0, "XIERQI SCHOOL");
            User user02 = new User("王小壮","xiaozhuang@sample.mail",17, 0, "GAOKE SCHOOL");
            User user03 = new User("王二壮", "wangerzhuang@sample.mail",15,0, "GAOKE SCHOOL");
            User user04 = new User("李二壮", "lierzhuang@sample.com",21,0, "KEYUAN SCHOOL");

            int result;

            // 注意，该实验结论基于MyBatis数据库，并且已经对id字段开启了主键自增设置。
            // 如果采用其他数据库或者采用其他设置，将得到不同的结果。

            // 使用Jdbc3KeyGenerator
            System.out.println("user01:");
            System.out.println("before insert :" + user01.toString());
            result = session.insert("com.github.yeecode.mybatisdemo.dao.UserDao.addUser_A", user01);
            System.out.println("insert result : " + result);
            System.out.println("after insert :" + user01.toString());

            // 使用SelectKeyGenerator(AFTER)
            System.out.println("user02:");
            System.out.println("before insert :" + user02.toString());
            result = session.insert("com.github.yeecode.mybatisdemo.dao.UserDao.addUser_B", user02);
            System.out.println("insert result : " + result);
            System.out.println("after insert :" + user02.toString());

            // 使用SelectKeyGenerator(BEFORE)
            // 此种设置用于不支持id自增或未启用id自增的数据库
            // 由于我们的数据库设置了id自增，会忽略传入的id值。因此会引发user03对象的变化，但是并不会生效的数据库中。
            System.out.println("user03:");
            System.out.println("before insert :" + user03.toString());
            result = session.insert("com.github.yeecode.mybatisdemo.dao.UserDao.addUser_C", user03);
            System.out.println("insert result : " + result);
            System.out.println("after insert :" + user03.toString());

            // 使用NoKeyGenerator，即不使用主键自增功能
            System.out.println("user04:");
            System.out.println("before insert :" + user04.toString());
            result = session.insert("com.github.yeecode.mybatisdemo.dao.UserDao.addUser_D", user04);
            System.out.println("insert result : " + result);
            System.out.println("after insert :" + user04.toString());

        }
    }
}

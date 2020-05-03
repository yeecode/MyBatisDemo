package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        System.out.println("Demo03 is a demo for configuration files, it can't work.");
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            User userBean = session.selectOne("com.github.yeecode.mybatisdemo.dao.UserDao.selectUser_A", 1);
            System.out.println(userBean.toString());
            userBean = session.selectOne("com.github.yeecode.mybatisdemo.dao.UserDao.selectUser_B", 1);
            System.out.println(userBean.toString());
            userBean = session.selectOne("com.github.yeecode.mybatisdemo.dao.UserDao.selectUser_B", 2);
            System.out.println(userBean.toString());

            List<User> userList = session.selectList("com.github.yeecode.mybatisdemo.dao.UserDao.selectUsers", new int[]{1, 2});
            for (User user : userList) {
                System.out.println(user.toString());
            }
        }
    }
}

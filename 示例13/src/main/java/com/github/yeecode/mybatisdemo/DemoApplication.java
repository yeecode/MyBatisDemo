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
            System.out.println("selectUser_A, param=1 : " + userBean.toString());
            userBean = session.selectOne("com.github.yeecode.mybatisdemo.dao.UserDao.selectUser_B", 1);
            System.out.println("selectUser_B, param=1 : " + userBean.toString());
            userBean = session.selectOne("com.github.yeecode.mybatisdemo.dao.UserDao.selectUser_B", 2);
            System.out.println("selectUser_B, param=2 : " + userBean.toString());

            User userParam = new User();
            userParam.setName("莉莉");
            userParam.setSchoolName("Garden School");
            userBean = session.selectOne("com.github.yeecode.mybatisdemo.dao.UserDao.selectUserByNameAndSchoolName", userParam);
            System.out.println("selectUsersByNameAndSchoolName, param=userParam : " + userBean.toString());

            userParam.setName(null);
            List<User> userList = session.selectList("com.github.yeecode.mybatisdemo.dao.UserDao.selectUsersByNameOrSchoolName", userParam);
            System.out.println("selectUsersByNameOrSchoolName: ");
            for (User user : userList) {
                System.out.println(user.toString());
            }

            userList = session.selectList("com.github.yeecode.mybatisdemo.dao.UserDao.selectUsers", new int[]{1, 2});
            System.out.println("selectUsers, param=1,2 : ");
            for (User user : userList) {
                System.out.println(user.toString());
            }
        }
    }
}

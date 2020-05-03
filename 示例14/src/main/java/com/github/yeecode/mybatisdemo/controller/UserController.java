package com.github.yeecode.mybatisdemo.controller;

import com.github.yeecode.mybatisdemo.dao.UserDao;
import com.github.yeecode.mybatisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/test")
    public String index() {

        User user = userDao.queryUserById(1);
        System.out.println("queryUserById(1):" + user.getName());

        List<User> userList = userDao.queryUsersByIds(new int[]{1,3});
        System.out.print("queryUsersByIds(new Integer[]{1,3}):");
        for (User item : userList) {
            System.out.print(item.getName() + "; ");
        }
        System.out.println();

        userList = userDao.queryUsersBySchoolName("Sunny School");
        System.out.print("queryUsersBySchoolName(\"Sunny School\") :");

        for (User item : userList) {
            System.out.print(item.getName() + "; ");
        }
        System.out.println();

        return "success";
    }
}

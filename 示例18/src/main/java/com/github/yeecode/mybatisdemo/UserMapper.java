package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.User;
import org.apache.ibatis.cursor.Cursor;

public interface UserMapper {
    Cursor<User> queryUserBySchoolName(User user);
}

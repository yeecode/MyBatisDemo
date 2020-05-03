package com.github.yeecode.mybatisdemo;

import java.util.List;

public interface UserMapper {
    List<User> queryUserBySchoolName(User user);
}

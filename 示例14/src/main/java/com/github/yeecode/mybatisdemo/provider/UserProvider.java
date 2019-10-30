package com.github.yeecode.mybatisdemo.provider;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    public String queryUsersBySchoolName() {
        return new SQL()
                .SELECT("*")
                .FROM("user")
                .WHERE("schoolName = #{schoolName}")
                .toString();
    }
}

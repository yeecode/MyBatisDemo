package com.github.yeecode.mybatisdemo.dao;

import com.github.yeecode.mybatisdemo.model.User;
import com.github.yeecode.mybatisdemo.provider.UserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM `user` WHERE `id` = #{id}")
    User queryUserById(Integer id);

    @Select("<script>" +
            "        SELECT *\n" +
            "        FROM `user`\n" +
            "        WHERE id IN\n" +
            "        <foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">\n" +
            "            #{id}\n" +
            "        </foreach>\n" +
            "    </script>")
    List<User> queryUsersByIds(int[] ids);

    @SelectProvider(type = UserProvider.class, method = "queryUsersBySchoolName")
    List<User> queryUsersBySchoolName(String schoolName);
}

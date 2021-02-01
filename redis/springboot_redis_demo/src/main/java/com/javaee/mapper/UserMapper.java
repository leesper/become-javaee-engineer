package com.javaee.mapper;

import com.javaee.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id} LIMIT 1")
    User findById(Integer id);
}

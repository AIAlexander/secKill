package com.alex.seckill.dao;

import com.alex.seckill.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author wsh
 * @date 2020-09-03
 */
@Mapper
@Component
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id, name) values (#{id}, #{name})")
    int saveUser(User user);

    @Select("select * from user where phone=#{phone}")
    User getUserByPhone(@Param("phone") String phone);
}

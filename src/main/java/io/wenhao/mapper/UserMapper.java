package io.wenhao.mapper;

import io.wenhao.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    public User getUser(@Param("id") String id);

    public User getUserByName(@Param("userName") String userName);

    public Integer addUserBasic(@Param("user") User user);

    public Integer addUserInfo(@Param("user") User user);

    public User updateUser(@Param("user") User user);

    public Integer deleteUserBasic(@Param("id") String id);

    public Integer deleteUserInfo(@Param("id") String id);

    public User login(@Param("name") String name, @Param("password") String password);
}
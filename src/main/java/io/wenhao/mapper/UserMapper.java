package io.wenhao.mapper;

import io.wenhao.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    public UserModel getUser(@Param("id") String id);

    public UserModel getUserByEmail(@Param("email") String email);

    public Integer addUserBasic(@Param("user") UserModel userModel);

    public Integer addUserInfo(@Param("user") UserModel userModel);

    public UserModel updateUser(@Param("user") UserModel userModel);

    public Integer deleteUserBasic(@Param("id") String id);

    public Integer deleteUserInfo(@Param("id") String id);

    public UserModel login(@Param("name") String name, @Param("password") String password);
}
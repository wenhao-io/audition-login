package io.wenhao.mapper;

import io.wenhao.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface LoginMapper {

    public UserModel login(@Param("name") String name, @Param("password") String password);
}
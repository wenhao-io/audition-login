package io.wenhao.mapper;

import io.wenhao.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface LoginMapper {

    public User login(@Param("name") String name, @Param("password") String password);
}
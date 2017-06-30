package io.wenhao.service.impl;

import io.wenhao.mapper.UserMapper;
import io.wenhao.model.UserModel;
import io.wenhao.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public UserModel getUser(String id) {
        return userMapper.getUser(id);
    }

    @Transactional
    @Override
    public Integer addUser(UserModel userModel) {
        String id = userMapper.getUserByEmail(userModel.getEmail());
        if (id != null) return 0;

        id = UUID.randomUUID().toString();
        userModel.setId(id);
        String salt = BCrypt.gensalt();
        userModel.setSalt(salt);
        String password = BCrypt.hashpw(userModel.getPassword(), salt);
        userModel.setPassword(password);

        Integer countBasic = userMapper.addUserBasic(userModel);
        Integer countInfo = userMapper.addUserInfo(userModel);
        return countBasic | countInfo;
    }

    @Transactional
    @Override
    public UserModel updateUser(UserModel userModel) {
        return null;
    }

    @Transactional
    @Override
    public Integer deleteUser(String id) {
        Integer countBasic = userMapper.deleteUserBasic(id);
        Integer countInfo = userMapper.deleteUserInfo(id);
        return countBasic | countInfo;
    }
}

package io.wenhao.service.impl;

import io.wenhao.mapper.UserMapper;
import io.wenhao.model.User;
import io.wenhao.service.IUserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String id) {
        return userMapper.getUser(id);
    }

    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Transactional
    @Override
    public Integer addUser(User user) {
        User user2 = userMapper.getUserByName(user.getUserName());
        if (user2 != null) return 0;

        user.setId(UUID.randomUUID().toString());
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String salt = secureRandom.nextBytes(3).toHex(); //一个Byte占两个字节，此处生成的3字节，字符串长度为6
        String password = new Md5Hash(user.getPassword(), salt, 2).toString();

        user.setSalt(salt);
        user.setPassword(password);

        Integer countBasic = userMapper.addUserBasic(user);
        Integer countInfo = userMapper.addUserInfo(user);
        return countBasic | countInfo;
    }

    @Transactional
    @Override
    public User updateUser(User user) {
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

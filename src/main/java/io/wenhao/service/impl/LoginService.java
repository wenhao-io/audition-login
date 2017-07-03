package io.wenhao.service.impl;

import io.wenhao.mapper.LoginMapper;
import io.wenhao.model.User;
import io.wenhao.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class LoginService implements ILoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Resource
    private LoginMapper loginMapper;

    @Override
    public User login(HttpSession session, String name, String password) {
        User user = loginMapper.login(name, password);
        if (user != null) {
            session.getId();
            session.setAttribute("id", user.getId());
            session.setAttribute("name", user.getName());
            session.setAttribute("email", user.getEmail());
        }
        return user;
    }
}

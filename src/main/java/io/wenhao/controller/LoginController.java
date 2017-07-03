package io.wenhao.controller;

import io.wenhao.model.User;
import io.wenhao.service.ILoginService;
import io.wenhao.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api")
public class LoginController {
    @Resource
    private ILoginService loginService;

    @Resource
    private IUserService userService;

    /**
     * 登录接口
     *
     * @param name     用户名称
     * @param password 密码
     * @return 是否成功
     */
    @ResponseStatus(HttpStatus.OK) // 响应状态，HTTP 状态码 200
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String name, @RequestParam String password) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
            Subject currentUser = SecurityUtils.getSubject();
            token.setRememberMe(true);
            currentUser.login(token);
//            Session session = currentUser.getSession();
        } catch (LockedAccountException e) {//账号被锁定
            return "3";
        } catch (IncorrectCredentialsException e) {//密码不正确
            return "2";
        } catch (AccountException e) {//账号不存在
            return "1";
        }
        return "0";
    }

    @ResponseStatus(HttpStatus.OK) // 响应状态，HTTP 状态码 200
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public User logout(HttpSession session, @RequestParam String name, @RequestParam String password) {
        return null;
    }
}
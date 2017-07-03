package io.wenhao.controller;

import io.wenhao.model.User;
import io.wenhao.service.ILoginService;
import io.wenhao.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public String login(HttpServletRequest request, @RequestParam String name, @RequestParam String password) {
        //获取session对象用来存储用户信息
        HttpSession session = request.getSession();
        User user = userService.getUserByName(name);

        if (user == null) return "1";

        try {
            //使用shiro来验证用户信息是否正确
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);

            Subject currentUser = SecurityUtils.getSubject();
            //记录用户访问的页面
            token.setRememberMe(true);
            //验证角色和权限
            currentUser.login(token);
            //在session中放入用户信息
            session.setAttribute("user", user);
        } catch (LockedAccountException e) {//账号被锁定
            return "3";
        } catch (IncorrectCredentialsException e) {//密码不正确
            return "2";
        }

        //用户登录时候首先验证用户信息（使用加盐处理）
        //验证用户是否多次登录被锁
        //验证用户登录次数
        return "0";
    }

    @ResponseStatus(HttpStatus.OK) // 响应状态，HTTP 状态码 200
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public User logout(HttpSession session, @RequestParam String name, @RequestParam String password) {
        return null;
    }
}
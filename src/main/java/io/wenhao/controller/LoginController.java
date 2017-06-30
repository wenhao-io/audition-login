package io.wenhao.controller;

import io.wenhao.model.UserModel;
import io.wenhao.service.ILoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {
    @Resource
    ILoginService loginService;

    @ResponseStatus(HttpStatus.OK) // 响应状态，HTTP 状态码 200
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public UserModel login(HttpSession session, @RequestParam String name, @RequestParam String password) {
        return null;
    }
}
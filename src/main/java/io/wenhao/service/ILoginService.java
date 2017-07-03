package io.wenhao.service;

import io.wenhao.model.User;

import javax.servlet.http.HttpSession;

public interface ILoginService {
    public User login(HttpSession session, String name, String password);
}

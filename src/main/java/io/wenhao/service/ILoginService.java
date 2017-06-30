package io.wenhao.service;

import io.wenhao.model.UserModel;

import javax.servlet.http.HttpSession;

public interface ILoginService {
    public UserModel login(HttpSession session, String name, String password);
}

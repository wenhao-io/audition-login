package io.wenhao.service;

import io.wenhao.model.UserModel;

public interface IUserService {
    public UserModel getUser(String id);

    public Integer addUser(UserModel userModel);

    public UserModel updateUser(UserModel userModel);

    public Integer deleteUser(String id);
}

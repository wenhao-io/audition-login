package io.wenhao.service;

import io.wenhao.model.User;

public interface IUserService {
    public User getUser(Integer id);

    public User getUserByName(String userName);

    public Integer addUser(User user);

    public User updateUser(User user);

    public Integer deleteUser(String id);
}

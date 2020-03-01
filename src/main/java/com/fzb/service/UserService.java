package com.fzb.service;

import com.fzb.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserByName(String uname);

    User findUserById(Integer uid);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer uid);

}

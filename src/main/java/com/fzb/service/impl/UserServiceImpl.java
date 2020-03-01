package com.fzb.service.impl;

import com.fzb.entity.User;
import com.fzb.mapper.UserMapper;
import com.fzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserByName(String uname) {
        return userMapper.findUserByName(uname);
    }

    @Override
    public User findUserById(Integer uid) {
        return userMapper.findUserById(uid);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Integer uid) {
        userMapper.deleteUser(uid);
    }
}

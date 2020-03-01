package com.fzb.mapper;

import com.fzb.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAllUser();

    User findUserByName(String uname);

    User findUserById(Integer uid);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer uid);

}

package com.samson.onlineshop.service;

import com.samson.onlineshop.domain.User;

import java.util.List;

public interface UserService {

    User findById(int id);
    User findByUsername(String uname);
    void saveUser(User user);
    User deleteByUsername(String uname);
    boolean isUserNameUnique(Integer id, String username);

    List<User> findAllUsers();

}

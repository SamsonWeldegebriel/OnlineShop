package com.samson.onlineshop.service;

import com.samson.onlineshop.domain.User;
import com.samson.onlineshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public User findByUsername(String uname) {
        return userRepository.findByUsername(uname);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User deleteByUsername(String uname) {
        return userRepository.deleteByUsername(uname);
    }

    public boolean isUserNameUnique(Integer id, String username) {
        User user = findByUsername(username);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

    public List<User> findAllUsers() {
        return null;
    }
}

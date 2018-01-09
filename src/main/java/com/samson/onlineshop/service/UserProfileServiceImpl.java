package com.samson.onlineshop.service;

import com.samson.onlineshop.domain.UserProfile;
import com.samson.onlineshop.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public List<UserProfile> findAll() {
        return (List<UserProfile>) userProfileRepository.findAll();
    }

    public UserProfile findByType(String type) {
        return userProfileRepository.findByType(type);
    }

    public UserProfile findById(int id) {
        return userProfileRepository.findById(id);
    }
}

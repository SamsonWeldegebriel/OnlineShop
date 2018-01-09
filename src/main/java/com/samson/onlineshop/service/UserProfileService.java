package com.samson.onlineshop.service;

import com.samson.onlineshop.domain.UserProfile;

import java.util.List;

public interface UserProfileService {
    List<UserProfile> findAll();
    UserProfile findByType(String type);
    UserProfile findById(int id);
}

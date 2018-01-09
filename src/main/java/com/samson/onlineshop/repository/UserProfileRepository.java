package com.samson.onlineshop.repository;

import com.samson.onlineshop.domain.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer>{

    UserProfile findByType(String type);
    UserProfile findById(int id);
}

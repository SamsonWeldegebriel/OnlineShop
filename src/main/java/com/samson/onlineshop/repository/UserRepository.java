package com.samson.onlineshop.repository;

import com.samson.onlineshop.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findById(int id);
    User findByUsername(String uname);
    User deleteByUsername(String uname);
}

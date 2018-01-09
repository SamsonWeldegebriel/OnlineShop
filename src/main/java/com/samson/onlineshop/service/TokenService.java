package com.samson.onlineshop.service;

import com.samson.onlineshop.domain.PersistentLogin;

public interface TokenService {

    PersistentLogin findById(String id);
}

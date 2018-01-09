package com.samson.onlineshop.repository;
 
import java.io.Serializable;
 
import java.lang.reflect.ParameterizedType;

import com.samson.onlineshop.domain.PersistentLogin;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManagerFactory;

public interface TokenRepository extends CrudRepository<PersistentLogin, String> {

    PersistentLogin findPersistentLoginBySeries(String series);

    PersistentLogin findPersistentLoginByUsername(String uname);

}
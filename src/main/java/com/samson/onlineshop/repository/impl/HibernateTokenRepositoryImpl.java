package com.samson.onlineshop.repository.impl;
 
import java.util.Date;

import com.samson.onlineshop.domain.PersistentLogin;
import com.samson.onlineshop.repository.TokenRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 
@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl implements PersistentTokenRepository{

    @Autowired
    TokenRepository tokenRepository;

    static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);
 

    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("Creating Token for user : {}", token.getUsername());
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setUsername(token.getUsername());
        persistentLogin.setSeries(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setLast_used(token.getDate());
        tokenRepository.save(persistentLogin);
 
    }
 

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        logger.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            PersistentLogin persistentLogin = (PersistentLogin) tokenRepository.findPersistentLoginBySeries(seriesId);
 
            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }
 

    public void removeUserTokens(String username) {
        logger.info("Removing Token if any for user : {}", username);
        PersistentLogin persistentLogin = (PersistentLogin) tokenRepository.findPersistentLoginByUsername(username);
        if (persistentLogin != null) {
            logger.info("rememberMe was selected");
            tokenRepository.delete(persistentLogin);
        }
 
    }
 

    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.info("Updating Token for seriesId : {}", seriesId);
        PersistentLogin persistentLogin = tokenRepository.findPersistentLoginBySeries(seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(lastUsed);
        tokenRepository.save(persistentLogin);
    }
 
}
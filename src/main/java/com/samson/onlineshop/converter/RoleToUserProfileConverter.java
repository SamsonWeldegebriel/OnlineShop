package com.samson.onlineshop.converter;

import com.samson.onlineshop.domain.UserProfile;
import com.samson.onlineshop.service.UserProfileService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import org.slf4j.Logger;

public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

    static final Logger LOGGER
            = LoggerFactory.getLogger(RoleToUserProfileConverter.class);

    @Autowired
    UserProfileService userProfileService;

    public UserProfile convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserProfile profile = userProfileService.findById(id);
        LOGGER.info("Profile : {} ", profile);
        return profile;
    }
}

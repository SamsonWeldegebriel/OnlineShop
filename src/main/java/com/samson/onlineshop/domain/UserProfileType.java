package com.samson.onlineshop.domain;

import java.io.Serializable;

public enum UserProfileType implements Serializable {

    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    /*user("user"),
    admin("admin"),
    guest("guest"),
    dba("dba");*/

    String userProfileType;

    private UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return userProfileType;
    }
}

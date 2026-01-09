package com.lcwd.userservices.services;

import com.lcwd.userservices.entities.User;

import java.util.List;

public interface userServices {

    // create
    User saveUser(User user);

    // get all user
    List<User> getAllUser();

    // get single user of given userId
    User getUser(String UserId);

    //TODO: delete
    //TODO: update
}

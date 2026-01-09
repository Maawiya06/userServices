package com.lcwd.userservices.services.implementation;

import com.lcwd.userservices.entities.User;
import com.lcwd.userservices.exception.ResourceNotFoundException;
import com.lcwd.userservices.repositories.UserRepositories;
import com.lcwd.userservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImplementation implements UserServices {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public User saveUser(User user) {
        // save the user in database
        return userRepositories.save(user);
    }

    @Override
    public List<User> getAllUser() {
        // get all user
        return userRepositories.findAll();
    }

    @Override
    public User getUser(String UserId) {
        // get user by id
        return userRepositories.findById(UserId).orElseThrow(() ->
                new ResourceNotFoundException("User with given Id is not found on server !! : " + UserId));
    }
}

package com.lcwd.userservices.services.implementation;

import com.lcwd.userservices.entities.User;
import com.lcwd.userservices.repositories.UserRepositories;
import com.lcwd.userservices.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImplementation implements userServices {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return List.of();
    }

    @Override
    public User getUser(String UserId) {
        return null;
    }
}

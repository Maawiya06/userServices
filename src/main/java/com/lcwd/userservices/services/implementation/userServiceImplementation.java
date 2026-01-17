package com.lcwd.userservices.services.implementation;

import com.lcwd.userservices.entities.User;
import com.lcwd.userservices.exception.ResourceNotFoundException;
import com.lcwd.userservices.repositories.UserRepositories;
import com.lcwd.userservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class userServiceImplementation implements UserServices {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public User saveUser(User user) {
        // generate random userId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
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
        // get user from database with the help of user repository
        User user = userRepositories.findById(UserId).orElseThrow(() ->
                new ResourceNotFoundException("User with given Id is not found on server !! : " + UserId));
        // fetch rating of the above user from rating services
        //http://localhost:8083/ratings/users/022411c7-628b-48ed-ac68-10a1ba40baf9

        return user;
    }
}

package com.lcwd.userservices.controller;

import com.lcwd.userservices.entities.User;
import com.lcwd.userservices.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    // create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    // get all user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userServices.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    // single get
    @GetMapping("/{userId}")
    @CircuitBreaker(name= "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user2 = userServices.getUser(userId);
        return ResponseEntity.ok(user2);
    }

    // creating fall back method for circuit breaker
    public ResponseEntity<User> ratingHotelFallBack(String ){

    }
}

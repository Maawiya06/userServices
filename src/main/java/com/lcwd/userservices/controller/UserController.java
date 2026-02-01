package com.lcwd.userservices.controller;

import com.lcwd.userservices.entities.User;
import com.lcwd.userservices.services.UserServices;
import com.lcwd.userservices.services.implementation.userServiceImplementation;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

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
    int retryCount = 1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name= "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
    @Retry(name = "ratingHotelServices", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user2 = userServices.getUser(userId);
        logger.info("Retry count: {}", retryCount);
        retryCount++;
        return ResponseEntity.ok(user2);
    }

    // creating fall back method for circuit breaker(fall back method return type and api return type will be same)
    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex){
//        logger.info("fall back is executed beacuse service is down : " , ex.getMessage());
        User user = User.builder()
                .userEmail("Dummy@gmail.com")
                .userName("Dummy")
                .userAbout("This user is created dummy because some services are down")
                .userId("GN2490")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

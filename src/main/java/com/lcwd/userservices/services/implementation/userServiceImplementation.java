package com.lcwd.userservices.services.implementation;

import com.lcwd.userservices.entities.Hotel;
import com.lcwd.userservices.entities.Rating;
import com.lcwd.userservices.entities.User;
import com.lcwd.userservices.exception.ResourceNotFoundException;
import com.lcwd.userservices.externalServices.HotelServices;
import com.lcwd.userservices.repositories.UserRepositories;
import com.lcwd.userservices.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class userServiceImplementation implements UserServices {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelServices;

    private Logger logger = LoggerFactory.getLogger(userServiceImplementation.class);

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
        Rating[] ratingOfUsers = restTemplate.
                getForObject("http://RATINGSERVICES/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{} ", ratingOfUsers);


        List<Rating> ratings = Arrays.stream(ratingOfUsers).toList();

        // fetching hotel from here
        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
            // http://localhost:8082/hotels/181a02fe-794b-459b-90e7-1733e066b99e

//            ResponseEntity<Hotel> forEntity = restTemplate.
//                    getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();

            // using feign client
            Hotel hotel = hotelServices.getHotel(rating.getHotelId());
//            logger.info("response status code: {}", forEntity.getStatusCode());
            // set the hotel to rating
            rating.setHotel(hotel);
            // return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRating(ratingList);
        return user;
    }

}

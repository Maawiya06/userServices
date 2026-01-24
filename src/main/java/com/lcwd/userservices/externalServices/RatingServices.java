package com.lcwd.userservices.externalServices;

import com.lcwd.userservices.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name= "RATINGSERVICES")
public interface RatingServices {

    //GET

    //POST
    Rating createRating();

    //PUT
    Rating updateRating();
}

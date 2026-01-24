package com.lcwd.userservices.externalServices;

import com.lcwd.userservices.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name= "RATINGSERVICES")
public interface RatingServices {

    //GET

    //POST
    @PostMapping("/ratings")
    Rating createRating();

    //PUT
    Rating updateRating();
}

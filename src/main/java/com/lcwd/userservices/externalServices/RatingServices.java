package com.lcwd.userservices.externalServices;

import com.lcwd.userservices.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name= "RATINGSERVICES")
public interface RatingServices {

    //GET

    //POST
    @PostMapping("/ratings")
    Rating createRating(Rating values);

    //PUT
    @PutMapping("ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
}

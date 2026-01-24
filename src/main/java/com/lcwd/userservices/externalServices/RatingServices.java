package com.lcwd.userservices.externalServices;

import com.lcwd.userservices.entities.Rating;
import org.bouncycastle.util.test.TestRandomBigInteger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name= "RATINGSERVICES")
public interface RatingServices {

    //GET

    //POST
    @PostMapping("/ratings")
    Rating createRating(Rating values);

    //PUT
    @PutMapping("ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    //DELETE
    @DeleteMapping("ratings/{ratingId}")
    Rating deleteRatings(@PathVariable String ratingId);
}

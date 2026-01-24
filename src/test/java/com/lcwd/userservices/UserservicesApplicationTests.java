package com.lcwd.userservices;

import com.lcwd.userservices.entities.Rating;
import com.lcwd.userservices.externalServices.RatingServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserservicesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingServices ratingServices;

//	@Test
//	void createRating(){
//		Rating rating = Rating.
//				builder().
//				rating(10).
//				ratingId("").
//				userId("").
//				hotelId("").
//				feedback("This is created using feign client which is most easy method").
//				build();
//		Rating savedRating = ratingServices.createRating(rating);
//		System.out.println("new Rating created");
//	}
}

package com.lcwd.userservices;

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

	void createRating(){

		ratingServices.createRating();
	}

}

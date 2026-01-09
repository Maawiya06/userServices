package com.lcwd.userservices.repositories;

import com.lcwd.userservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, String> {
    // you want to implement any custom method or query

}

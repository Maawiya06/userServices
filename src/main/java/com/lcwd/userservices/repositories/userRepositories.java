package com.lcwd.userservices.repositories;

import com.lcwd.userservices.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepositories extends JpaRepository<user, String> {
    // you want to implement any custom method or query

}

package com.lcwd.userservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "microservices_user")
public class user {

    @Id
    @Column(name= "id")
    private String userId;
    private String userName;
    private String userEmail;
    private String userAbout;

}

package com.lcwd.userservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "microservices_user")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Column(name= "id")
    private String userId;
    @Column(name= "NAME", length = 20)
    private String userName;
    @Column(name= "EMAIL")
    private String userEmail;
    @Column(name= "ABOUT")
    private String userAbout;

    private List<Rating> rating = new ArrayList<>();

}

package com.nisshome.hpfullstack1.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<UserTypeItem> userTypeItems;

    // None should be nullable
    private String username; // Should be unique
    private String password;


    public UserEntity(){ }

    public UserEntity(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void setUserTypeItems(List<UserTypeItem> userTypeItems){ this.userTypeItems = userTypeItems; }
}

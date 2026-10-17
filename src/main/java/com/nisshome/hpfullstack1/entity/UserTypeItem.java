package com.nisshome.hpfullstack1.entity;

import jakarta.persistence.*;

@Entity
public class UserTypeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity userEntity;

    @ManyToOne
    private UserType userType;

    public UserTypeItem(){ }

    public UserTypeItem(UserEntity userEntity, UserType userType) {
        this.userEntity = userEntity;
        this.userType = userType;
    }
}

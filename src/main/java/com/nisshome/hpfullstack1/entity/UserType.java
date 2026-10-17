package com.nisshome.hpfullstack1.entity;

import jakarta.persistence.*;

@Entity
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    public UserType(){ }

    public UserType(String typeName) {
        this.typeName = typeName;
    }
}

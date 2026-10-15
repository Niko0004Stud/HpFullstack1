package com.nisshome.hpfullstack1.AuthHandling;

import com.nisshome.hpfullstack1.entity.UserEntity;

public class AuthMapper {
    public static LoginResponse toLoginResponse(UserEntity userEntity){
        return new LoginResponse(
                userEntity.getUsername()
        );
    }
}

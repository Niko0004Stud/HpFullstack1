package com.nisshome.hpfullstack1.AuthHandling;

import com.nisshome.hpfullstack1.entity.UserEntity;
import com.nisshome.hpfullstack1.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserEntityRepository userEntityRepository;

    public AuthService(UserEntityRepository userEntityRepository){
        this.userEntityRepository = userEntityRepository;
    }

    public LoginResponse login(LoginRequest loginRequest){
        UserEntity userEntity = userEntityRepository.findByUsernameAndPassword(loginRequest.username(), loginRequest.password())
                .orElseThrow(() -> new RuntimeException(
                        "User not found with provided login information: "+loginRequest.username()+" :: "+loginRequest.password()
                ));
        return AuthMapper.toLoginResponse(userEntity);
    }
}

package com.nisshome.hpfullstack1.AuthHandling;

import com.nisshome.hpfullstack1.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository){
        this.authRepository = authRepository;
    }

    public LoginResponse login(LoginRequest loginRequest){
        UserEntity userEntity = authRepository.findByUsernameAndPassword(loginRequest.username(), loginRequest.password())
                .orElseThrow(() -> new RuntimeException(
                        "User not found with provided login information: "+loginRequest.username()+" :: "+loginRequest.password()
                ));
        return AuthMapper.toLoginResponse(userEntity);
    }
}

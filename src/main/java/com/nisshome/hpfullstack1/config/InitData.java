package com.nisshome.hpfullstack1.config;

import com.nisshome.hpfullstack1.AuthHandling.AuthRepository;
import com.nisshome.hpfullstack1.entity.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final AuthRepository authRepository;

    public InitData(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(authRepository.count() > 0){
            return;
        }

        UserEntity user1 = new UserEntity("Nicklas", "1234");
        UserEntity user2 = new UserEntity("Nissingolf", "0000");
        authRepository.save(user1);
        authRepository.save(user2);
    }
}

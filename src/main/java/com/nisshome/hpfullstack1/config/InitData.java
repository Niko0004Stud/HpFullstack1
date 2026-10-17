package com.nisshome.hpfullstack1.config;

import com.nisshome.hpfullstack1.entity.UserTypeItem;
import com.nisshome.hpfullstack1.repository.UserEntityRepository;
import com.nisshome.hpfullstack1.entity.UserEntity;
import com.nisshome.hpfullstack1.entity.UserType;
import com.nisshome.hpfullstack1.repository.UserTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private final UserEntityRepository userEntityRepository;
    private final UserTypeRepository userTypeRepository;

    public InitData(UserEntityRepository userEntityRepository, UserTypeRepository userTypeRepository) {
        this.userEntityRepository = userEntityRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userEntityRepository.count() > 0){
            return;
        }

        UserType userType1 = new UserType("admin");
        UserType userType2 = new UserType("base");
        UserType userType3 = new UserType("test");

        userTypeRepository.save(userType1);
        userTypeRepository.save(userType2);
        userTypeRepository.save(userType3);

        UserEntity user1 = new UserEntity("Nicklas", "1234");
        UserTypeItem userTypeItem1 = new UserTypeItem(user1, userType1);
        UserTypeItem userTypeItem2 = new UserTypeItem(user1, userType3);
        user1.setUserTypeItems(List.of(userTypeItem1, userTypeItem2));

        UserEntity user2 = new UserEntity("Nissingolf", "0000");
        UserTypeItem userTypeItem3 = new UserTypeItem(user2, userType2);
        user2.setUserTypeItems(List.of(userTypeItem3));

        userEntityRepository.save(user1);
        userEntityRepository.save(user2);


    }
}

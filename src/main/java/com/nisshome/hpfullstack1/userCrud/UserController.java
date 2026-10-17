package com.nisshome.hpfullstack1.userCrud;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request){

    }
}

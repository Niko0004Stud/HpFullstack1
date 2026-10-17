package com.nisshome.hpfullstack1.userCrud;

public record CreateUserRequest(String username, String password, Long[] userTypes) {
}

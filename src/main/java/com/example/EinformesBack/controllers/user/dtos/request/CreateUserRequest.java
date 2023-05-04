package com.example.EinformesBack.controllers.user.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUserRequest {

    private String username;
    private String password;
}

package com.example.EinformesBack.controllers.user.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetUserResponse {

    private Long id_User;
    private String username;
    private String email;
}

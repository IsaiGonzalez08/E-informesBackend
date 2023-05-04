package com.example.EinformesBack.services.interfaces;


import com.example.EinformesBack.controllers.user.dtos.request.CreateUserRequest;
import com.example.EinformesBack.controllers.user.dtos.request.UpdateUserRequest;
import com.example.EinformesBack.controllers.user.dtos.responses.GetUserResponse;

import java.util.List;

public interface IUserService {
    List<GetUserResponse> list();
    GetUserResponse getUser(Long id);
    void create(CreateUserRequest request);
    GetUserResponse update(UpdateUserRequest request, Long id);
    void delete(Long id);
}

package com.example.EinformesBack.controllers.user;

import com.example.EinformesBack.controllers.user.dtos.request.CreateUserRequest;
import com.example.EinformesBack.controllers.user.dtos.request.UpdateUserRequest;
import com.example.EinformesBack.controllers.user.dtos.responses.GetUserResponse;
import com.example.EinformesBack.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping("list")
    public List<GetUserResponse> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public GetUserResponse get(@PathVariable Long id) {
        return service.getUser(id);
    }

    @PostMapping
    public void create(@RequestBody CreateUserRequest request) {
        service.create(request);
    }

    @PutMapping("{id}")
    public GetUserResponse update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return service.update(request, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

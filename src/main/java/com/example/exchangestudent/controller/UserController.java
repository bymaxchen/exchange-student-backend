package com.example.exchangestudent.controller;

import com.example.exchangestudent.model.dto.UserDTO;
import com.example.exchangestudent.service.IUser;
import com.example.exchangestudent.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUser userService;

    @PostMapping("/signup")
    public BaseResponse<Boolean> signUp(@RequestBody UserDTO userDTO) {
        return BaseResponse.ok(userService.signUp(userDTO));
    }
}

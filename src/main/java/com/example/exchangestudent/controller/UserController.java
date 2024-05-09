package com.example.exchangestudent.controller;

import com.example.exchangestudent.config.CookieConfig;
import com.example.exchangestudent.emums.ErrorEnums;
import com.example.exchangestudent.model.dto.ProfileDTO;
import com.example.exchangestudent.model.dto.UserDTO;
import com.example.exchangestudent.service.IUser;
import com.example.exchangestudent.util.BaseResponse;
import com.example.exchangestudent.util.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUser userService;

    @Autowired
    private CookieConfig cookieConfig;

    @PostMapping("/sign-up")
    public BaseResponse<Boolean> signUp(@RequestBody UserDTO userDTO) {
        return BaseResponse.ok(userService.signUp(userDTO));
    }

    @PostMapping("/sign-in")
    public BaseResponse<String> signIn(@RequestBody UserDTO userDTO, HttpServletResponse response) {

        String token = userService.signIn(userDTO);

        if (token == null) {
            return BaseResponse.error(ErrorEnums.LOGIN_ERROR, "");
        }

        response.addCookie(CookieUtil.generateCookie(cookieConfig.getName(), token, cookieConfig.getPath()));
        return BaseResponse.ok(userService.signIn(userDTO));
    }

    @PostMapping("/logout")
    public BaseResponse<Object> logout(HttpServletResponse response) {
        response.addCookie(CookieUtil.generateCookie(cookieConfig.getName(), "", cookieConfig.getPath()));

        return BaseResponse.ok();
    }

    @GetMapping("/profile")
    public BaseResponse<ProfileDTO> getProfileInfo() {
        return BaseResponse.ok(userService.getProfileInfo());
    }
}

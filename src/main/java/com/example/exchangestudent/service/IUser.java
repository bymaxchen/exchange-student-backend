package com.example.exchangestudent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exchangestudent.model.dto.UserDTO;
import com.example.exchangestudent.model.po.User;

public interface IUser  extends IService<User> {
    boolean signUp(UserDTO userDTO);
}

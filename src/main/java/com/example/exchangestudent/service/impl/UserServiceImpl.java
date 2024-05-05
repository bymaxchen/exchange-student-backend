package com.example.exchangestudent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exchangestudent.convert.UserConvert;
import com.example.exchangestudent.mapper.UserMapper;
import com.example.exchangestudent.model.dto.UserDTO;
import com.example.exchangestudent.model.po.User;
import com.example.exchangestudent.service.IUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUser {
    private UserConvert userConvert;

    private PasswordEncoder passwordEncoder;

    @Override
    public boolean signUp(UserDTO userDTO) {
        User user = userConvert.dto2po(userDTO);

        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));

        return save(user);
    }
}

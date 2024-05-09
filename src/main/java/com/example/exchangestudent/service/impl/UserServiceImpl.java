package com.example.exchangestudent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.exchangestudent.convert.UserConvert;
import com.example.exchangestudent.mapper.UserMapper;
import com.example.exchangestudent.model.dto.ProfileDTO;
import com.example.exchangestudent.model.dto.UserDTO;
import com.example.exchangestudent.model.po.User;
import com.example.exchangestudent.service.IUser;
import com.example.exchangestudent.util.EncryptUtil;
import com.example.exchangestudent.util.JwtUtil;
import com.example.exchangestudent.util.SessionContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUser {
    private UserConvert userConvert;

    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean signUp(UserDTO userDTO) {
        User user = userConvert.dto2po(userDTO);

        user.setPasswordHash(EncryptUtil.encodePassword(userDTO.getPassword()));

        return save(user);
    }

    @Override
    public String signIn(UserDTO userDTO) {
        User user = lambdaQuery().eq(User::getEmail, userDTO.getEmail()).one();

        if (user == null || !passwordEncoder.matches(userDTO.getPassword(), user.getPasswordHash())) {
            return null;
        }

        return jwtUtil.generateUserToken(user);
    }

    @Override
    public ProfileDTO getProfileInfo() {
        User user = lambdaQuery().eq(User::getUserId, SessionContext.getUserId()).one();

        return userConvert.po2dto(user);
    }
}

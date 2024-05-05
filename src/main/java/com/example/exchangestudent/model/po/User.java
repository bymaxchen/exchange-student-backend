package com.example.exchangestudent.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("users")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long userId;

    private String username;

    private String email;

    private String passwordHash;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private int gender;

    private int nationalityId;

    private String profilePictureUrl;

    private String bio;

    private LocalDateTime registrationDate;
//
//    private LocalDateTime lastLogin;
//
    private boolean isActive;
}

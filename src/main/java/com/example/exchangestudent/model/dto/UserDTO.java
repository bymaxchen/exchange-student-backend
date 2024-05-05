package com.example.exchangestudent.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int gender;
    private String profilePictureUrl;
    private String bio;


}

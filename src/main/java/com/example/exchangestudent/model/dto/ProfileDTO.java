package com.example.exchangestudent.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileDTO {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int gender;
    private String profilePictureUrl;
    private String bio;
}

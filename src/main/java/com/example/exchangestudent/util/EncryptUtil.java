package com.example.exchangestudent.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptUtil {
    public static String encodePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}

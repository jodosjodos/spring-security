package com.springSecurity.model;

import lombok.Data;

@Data
public class SignUpRequest {

    private  String fullName;
    private  String email;
    private  String phoneNumber;
    private  String password;
}

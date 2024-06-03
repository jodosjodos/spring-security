package com.springSecurity.model;

import com.springSecurity.entities.Role;
import lombok.Data;

@Data
public class SignUpRequest {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;

}

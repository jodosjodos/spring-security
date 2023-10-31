package com.springSecurity.services.impl;

import com.springSecurity.errors.exception.ApiRequestException;
import com.springSecurity.repository.UserRepository;
import com.springSecurity.services.UserServiceSecurity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceSecurityImpl implements UserServiceSecurity {
    private final UserRepository userRepository;

//     find user by username
    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new ApiRequestException("User not found", HttpStatus.NOT_FOUND));
    }


}

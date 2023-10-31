package com.springSecurity;

import com.springSecurity.entities.Role;
import com.springSecurity.entities.User;
import com.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurity implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity.class, args);
    }

    public void run(String... args) {
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if (null == adminAccount) {
            User user = new User();
            user.setEmail("jodos20061@gmail.com");
            user.setFullName("Jean de Dieu NSHIMYUMUKIZA");
            user.setRole(Role.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("jodos2006"));
            userRepository.save(user);
        }

    }
}

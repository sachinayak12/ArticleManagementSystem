package com.user.user.controller;

import com.user.user.dto.UserDTO;
import com.user.user.dto.UserDetailsDTO;
import com.user.user.entity.UserEntity;
import com.user.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {



    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserEntity user)
    {

    UserDTO userDTO =  userService.signup(user);
      return ResponseEntity.ok(userDTO);

    }
//    @PostMapping("/login")
//    public ResponseEntity<UserDetailsDTO> login(@RequestBody UserEntity user) {
//        try {
//            UserDetailsDTO dto = userService.login(user);
//            return ResponseEntity.ok(dto);
//        } catch (Exception e) {
//            log.error("Error while logging in: {}", e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody UserEntity user) {
    try {
        UserDetailsDTO dto = userService.login(user);

        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            // Login failed
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }

    } catch (Exception e) {
        log.error("Error while logging in: {}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong");
    }
}


}

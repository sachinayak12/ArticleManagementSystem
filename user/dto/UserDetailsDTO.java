package com.user.user.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDetailsDTO {
    private Long userId;
    private String userName;
    private String userEmail;
}

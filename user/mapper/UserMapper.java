package com.user.user.mapper;

import com.user.user.dto.UserCredentialsDTO;
import com.user.user.dto.UserDTO;
import com.user.user.dto.UserDetailsDTO;
import com.user.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    @Autowired
    UserDTO userDTO;

    @Autowired
    UserCredentialsDTO userCredentialsDTO;



    public  UserDTO toDTO(UserEntity userEntity)
    {
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setPassword(userEntity.getPassword());
        return userDTO;

    }
    public  UserCredentialsDTO toCredentialsDTO(UserEntity userEntity)
    {
        userCredentialsDTO.setUserEmail(userEntity.getUserEmail());
        userCredentialsDTO.setUserName(userEntity.getUserName());
        userCredentialsDTO.setPassword(userEntity.getPassword());
        return userCredentialsDTO;

    }

    public UserDetailsDTO toUserDetails(UserEntity userEntity) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setUserId(userEntity.getUserId());
        userDetailsDTO.setUserName(userEntity.getUserName());
        userDetailsDTO.setUserEmail(userEntity.getUserEmail());

        return userDetailsDTO;
    }
}

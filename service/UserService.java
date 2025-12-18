package com.user.user.service;

import com.user.user.dto.UserCredentialsDTO;
import com.user.user.dto.UserDTO;
import com.user.user.dto.UserDetailsDTO;
import com.user.user.entity.UserEntity;
import com.user.user.mapper.UserMapper;
import com.user.user.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserService {


    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    UserMapper mapper = new UserMapper();
    public UserDTO signup(UserEntity user) {
        try{
            if(null != user)
            {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return mapper.toDTO(userRepo.save(user));
            }

        }
        catch(RuntimeException e){
            log.info("error in storing the user data,{}",e);
        }
        return null;
    }

    public UserDetailsDTO login(UserEntity user)
    {
        try
        {
            UserEntity userEntity = userRepo.findByUserEmail(user.getUserEmail());
            if(null != userEntity)
            {
                if(passwordEncoder.matches(user.getPassword(), userEntity.getPassword()))
                {
                    return mapper.toUserDetails(userEntity);
                }

            }
        }
        catch(Exception e)
        {
            log.info("Error in logging in,{}",e);
        }
        return null;
    }
//public UserDetailsDTO login(UserEntity user){
//    try {
//        UserEntity userEntity = userRepo.findByUserEmail(user.getUserEmail());
//
//        if (null != userEntity &&
//                passwordEncoder.matches(user.getPassword(), userEntity.getPassword())) {
//
//            return mapper.toUserDetails(userEntity);
//        }
//
//    } catch (Exception e) {
//        log.error("Error in logging in: {}", e);
//    }
//
//    return null;  // controller handles this properly
//}

}

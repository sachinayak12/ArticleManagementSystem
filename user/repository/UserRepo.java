package com.user.user.repository;

import com.user.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    @Query(value = "SELECT * FROM user_entity WHERE user_email = ?1", nativeQuery = true)
    UserEntity findByUserEmail(String userEmail);
}

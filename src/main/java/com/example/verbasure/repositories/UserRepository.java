package com.example.verbasure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.verbasure.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

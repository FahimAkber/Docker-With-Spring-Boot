package com.example.dockerwithspringboot.repository;

import com.example.dockerwithspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMobileNumber(String mobileNumber);
}

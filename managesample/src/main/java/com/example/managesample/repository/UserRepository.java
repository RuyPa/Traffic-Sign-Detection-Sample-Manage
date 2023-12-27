package com.example.managesample.repository;

import com.example.managesample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUsername(String name);
}

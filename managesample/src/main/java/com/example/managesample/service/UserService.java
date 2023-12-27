package com.example.managesample.service;

import com.example.managesample.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserByUserName(String username);
}

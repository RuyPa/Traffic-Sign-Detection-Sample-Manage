package com.example.managesample.service.impl;

import com.example.managesample.model.User;
import com.example.managesample.repository.UserRepository;
import com.example.managesample.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    @Override
    public User getUserByUserName(String username) {
        return userRepository.getUserByUsername(username);
    }
}

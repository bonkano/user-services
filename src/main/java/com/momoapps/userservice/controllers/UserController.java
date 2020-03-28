package com.momoapps.userservice.controllers;

import com.momoapps.userservice.dao.UserRepository;
import com.momoapps.userservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/userByKeyword/{keyword}")
    public List<User> findAllUsers(@PathVariable("keyword") String keyword) {
        return userRepository.findUsersByKeywordAllIgnoringCase(keyword);
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }
}

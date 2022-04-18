package com.auth.auth.controller;

import com.auth.auth.model.User;
import com.auth.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> userList() {
        return userService.userList();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }



}

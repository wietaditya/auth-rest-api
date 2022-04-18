package com.auth.service;


import com.auth.model.User;
import com.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> userList() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public ResponseEntity<Object> save(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());

        if (userOptional.isPresent()) {
            return new ResponseEntity<>("username sudah terpakai", HttpStatus.CONFLICT);
        } else {
            userRepository.save(user);
            return new ResponseEntity<>("sukses", HttpStatus.CREATED);
        }

    }

    public ResponseEntity<Object> update(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        String lastPass = userRepository.getPasswordById(user.getId());

        if (userOptional.isPresent()) {
            return new ResponseEntity<>("username sudah dipakai", HttpStatus.CONFLICT);
        } else {
            if (lastPass.equals(user.getPassword())) {
                return new ResponseEntity<>("password tidak boleh sama dengan sebelumnya", HttpStatus.BAD_REQUEST);
            } else {
                userRepository.save(user);
                return new ResponseEntity<>("sukses", HttpStatus.CREATED);
            }
        }
    }

    public ResponseEntity<Object> login(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        String password = userRepository.getPasswordByUsername(user.getUsername());

        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
           return new ResponseEntity<>("username dan/atau password kosong", HttpStatus.BAD_REQUEST);
        } else if (userOptional.isPresent() && user.getPassword().equals(password)) {
            return new ResponseEntity<>("sukses login",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("username dan/atau password salah",HttpStatus.BAD_REQUEST);
        }
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}

package com.example.verbasure.controllers;

import com.example.verbasure.DTO.UserDTO;
import com.example.verbasure.models.User;
import com.example.verbasure.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserController {

    public final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser (@RequestBody User user){

        User isUserExists = userRepository.findByEmail(user.getEmail());

        if (isUserExists == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User addUser = userRepository.save(user);
            return new ResponseEntity<>("User added successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User already exists",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("getUserById/{id}")
    public Optional<User> getUserById(@PathVariable("id") int id){
        return userRepository.findById(id);
    }

    @PostMapping("userLogin")
    public ResponseEntity<String> userLogin(@RequestBody UserDTO userDTO){

        User user = userRepository.findByEmail(userDTO.getEmail());

        if(user == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

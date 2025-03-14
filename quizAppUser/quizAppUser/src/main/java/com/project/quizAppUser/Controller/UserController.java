package com.project.quizAppUser.Controller;

import com.project.quizAppUser.Model.Users;
import com.project.quizAppUser.Service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:3000")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody Users user){
       Users user1= service.addUser(user);
        if (user1!=null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user1);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return service.verify(user);
    }

    @GetMapping("/user")
    public List<Users> getUser(){
        List<Users> user=service.getUser();
        return user;
    }


}

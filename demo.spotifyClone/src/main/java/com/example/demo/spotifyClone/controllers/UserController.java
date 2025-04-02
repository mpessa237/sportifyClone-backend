package com.example.demo.spotifyClone.controllers;

import com.example.demo.spotifyClone.dto.user.UserReqDTO;
import com.example.demo.spotifyClone.dto.user.UserRespDTO;
import com.example.demo.spotifyClone.entity.User;
import com.example.demo.spotifyClone.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ResponseBody
    @PostMapping(path = "user/add")
    public ResponseEntity<UserRespDTO> addUser(@Valid @RequestBody UserReqDTO userReqDTO){
        UserRespDTO addUser = this.userService.addUser(userReqDTO);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }
    @GetMapping(path = "user/get-all")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity
                .ok(this.userService.getAllUser());
    }
    @GetMapping(path = "user/get-user-by-id/{userId}")
    public ResponseEntity<UserRespDTO> getUserById(@PathVariable Integer userId){
        return ResponseEntity
                .ok(this.userService.getUserById(userId));
    }
    @GetMapping(path = "user/get-user-by-username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return ResponseEntity
                .ok(this.userService.getUserByUsername(username));
    }
    @PutMapping(path = "user/update-User/{userId}")
    public ResponseEntity<User> updateUserById(@Valid @RequestBody User user, @PathVariable Integer userId){
        return ResponseEntity
                .ok(this.userService.updateUser(user, userId));
    }
    @DeleteMapping(path = "user/delete/{userId}")
    public ResponseEntity<String> deleteUser (@PathVariable Integer userId){

        this.userService.deleteUser(userId);
        return ResponseEntity
                .ok("user deleted successfully!");
    }
}

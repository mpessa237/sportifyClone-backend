package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.user.UserReqDTO;
import com.example.demo.spotifyClone.dto.user.UserRespDTO;
import com.example.demo.spotifyClone.entity.User;

import java.util.List;

public interface UserService {
    UserRespDTO addUser(UserReqDTO userReqDTO);
    List<User> getAllUser();
    UserRespDTO getUserById(Integer userId);
    UserRespDTO getUserByUsername(String username);
    UserRespDTO getUserByEmail(String email);
    User updateUser(User user,Integer userId);
    void deleteUser(Integer userId);
}

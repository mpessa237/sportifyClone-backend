package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.user.UserReqDTO;
import com.example.demo.spotifyClone.dto.user.UserRespDTO;
import com.example.demo.spotifyClone.entity.User;
import com.example.demo.spotifyClone.exception.ResourceNotFoundException;
import com.example.demo.spotifyClone.mapper.UserMapper;
import com.example.demo.spotifyClone.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserRespDTO addUser(UserReqDTO userReqDTO) {


        User user = this.userMapper.toEntity(userReqDTO);
        User addUser = this.userRepo.save(user);
        return this.userMapper.toDto(addUser);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public UserRespDTO getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found!!"));
        return this.userMapper.toDto(user);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = this.userRepo.findUserByUsername(username);
        if (user.isEmpty())
            throw new ResourceNotFoundException("user not found!!");
        return user.get();
    }

    @Override
    public User updateUser(User user, Integer userId) {

        Optional<User> userOptional = this.userRepo.findById(userId);
        if (userOptional.isEmpty())
            throw new ResourceNotFoundException("user not found!!");
        if (user.getUsername()!=null)
            userOptional.get().setUsername(user.getUsername());
        if (user.getEmail()!=null)
            userOptional.get().setEmail(user.getEmail());
        if (user.getPassword()!=null)
            userOptional.get().setPassword(user.getPassword());

        return this.userRepo.saveAndFlush(userOptional.get());
    }

    @Override
    public void deleteUser(Integer userId) {
        this.userRepo.delete(this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found!!")));

    }
}

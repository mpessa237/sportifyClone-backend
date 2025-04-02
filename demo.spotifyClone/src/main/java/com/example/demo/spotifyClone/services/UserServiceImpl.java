package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.user.UserReqDTO;
import com.example.demo.spotifyClone.dto.user.UserRespDTO;
import com.example.demo.spotifyClone.entity.User;
import com.example.demo.spotifyClone.exception.BusinessException;
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
        // Validation de l'email
        if (!EmailValidation.isValidEmail(userReqDTO.getEmail())) {
            throw new BusinessException("Format d'email invalide");
        }
        // Vérification unicité
        if (userRepo.existsByEmail(userReqDTO.getEmail())) {
            throw new BusinessException("Email déjà utilisé");
        }
        try {
            User user = this.userMapper.toEntity(userReqDTO);
            User addUser = this.userRepo.save(user);
            return this.userMapper.toDto(addUser);
        } catch (Exception e) {
            throw new BusinessException("Erreur lors de la création de l'utilisateur");
        }
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
    public UserRespDTO getUserByUsername(String username) {
        User user = this.userRepo.findUserByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("user not found!!"));
        return this.userMapper.toDto(user);
    }

    @Override
    public UserRespDTO getUserByEmail(String email) {
        User user = this.userRepo.findUserByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("user not found!!"));
        return this.userMapper.toDto(user);
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

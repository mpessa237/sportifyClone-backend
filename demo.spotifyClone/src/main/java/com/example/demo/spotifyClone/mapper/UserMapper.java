package com.example.demo.spotifyClone.mapper;

import com.example.demo.spotifyClone.dto.user.UserReqDTO;
import com.example.demo.spotifyClone.dto.user.UserRespDTO;
import com.example.demo.spotifyClone.entity.Playlist;
import com.example.demo.spotifyClone.entity.Subscription;
import com.example.demo.spotifyClone.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public User toEntity(UserReqDTO userReqDTO){
        User user = new User();
        user.setUsername(userReqDTO.getUsername());
        user.setPassword(userReqDTO.getPassword());
        user.setEmail(userReqDTO.getEmail());

        if (userReqDTO.getSubscriptionId() != null) {
            Subscription subscription = new Subscription();
            subscription.setSubscriptionId(userReqDTO.getSubscriptionId()); // Définir l'ID de la souscription
            user.setSubscription(subscription); // Associer la souscription à l'utilisateur
        }

        return user;
    }
    public UserRespDTO toDto(User user) {
        UserRespDTO userRespDTO = new UserRespDTO();
        userRespDTO.setUserId(user.getUserId());
        userRespDTO.setUsername(user.getUsername());
        userRespDTO.setEmail(user.getEmail());

        if (user.getSubscription()!=null){
            userRespDTO.setSubscriptionId(user.getSubscription().getSubscriptionId());
        }

        return userRespDTO;
    }
}

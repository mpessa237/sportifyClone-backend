package com.example.demo.spotifyClone.dto.user;

import lombok.Data;

import java.util.List;

@Data
public class UserRespDTO {
    private Integer userId;
    private String username;
    private String email;
    private Integer subscriptionId;

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPlaylistIds(List<Integer> playlistIds) {
    }
}

package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.entity.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser addAppUser(AppUser appUser);
    List<AppUser> getAllAppUser();
    AppUser loadUserByUsername(String username);
}

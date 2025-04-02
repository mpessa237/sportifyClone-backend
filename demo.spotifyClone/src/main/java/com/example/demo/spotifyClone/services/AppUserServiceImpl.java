package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.entity.AppUser;
import com.example.demo.spotifyClone.repository.AppUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{
    private final AppUserRepo appUserRepo;

    public AppUserServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public AppUser addAppUser(AppUser appUser) {
        return this.appUserRepo.save(appUser);
    }

    @Override
    public List<AppUser> getAllAppUser() {
        return this.appUserRepo.findAll();
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return this.appUserRepo.findByUsername(username);
    }
}

package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.entity.AppRole;
import com.example.demo.spotifyClone.entity.AppUser;
import com.example.demo.spotifyClone.repository.AppRoleRepo;
import com.example.demo.spotifyClone.repository.AppUserRepo;
import org.springframework.stereotype.Service;

@Service
public class AppRoleServiceImpl implements AppRoleService{
    private final AppRoleRepo appRoleRepo;
    private final AppUserRepo appUserRepo;

    public AppRoleServiceImpl(AppRoleRepo appRoleRepo, AppUserRepo appUserRepo) {
        this.appRoleRepo = appRoleRepo;
        this.appUserRepo = appUserRepo;
    }

    @Override
    public AppRole addAppRole(AppRole appRole) {
        return this.appRoleRepo.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = this.appUserRepo.findByUsername(username);
        AppRole appRole = this.appRoleRepo.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);

    }
}

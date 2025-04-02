package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.entity.AppRole;

public interface AppRoleService {
    AppRole addAppRole(AppRole appRole);
    void addRoleToUser(String username,String roleName);
}

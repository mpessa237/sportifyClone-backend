package com.example.demo.spotifyClone.repository;

import com.example.demo.spotifyClone.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole,Integer> {
    AppRole findByRoleName(String roleName);
}

package com.example.demo.spotifyClone.repository;

import com.example.demo.spotifyClone.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Integer> {
    AppUser findByUsername(String username);
}

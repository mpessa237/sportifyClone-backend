package com.example.demo.spotifyClone.repository;

import com.example.demo.spotifyClone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username=:username")
    Optional<User> findUserByUsername(@Param("username")String username);
}

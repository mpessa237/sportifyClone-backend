package com.example.demo.spotifyClone.repository;

import com.example.demo.spotifyClone.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaylistRepo extends JpaRepository<Playlist,Integer> {
    @Query("SELECT p FROM Playlist p WHERE p.name=:name")
    Optional<Playlist> findPlaylistByName(@Param("name")String name);
}

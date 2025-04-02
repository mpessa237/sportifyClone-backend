package com.example.demo.spotifyClone.repository;

import com.example.demo.spotifyClone.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepo extends JpaRepository<Album,Integer> {
    @Query("SELECT a FROM Album a WHERE a.name=:name")
    Optional<Album> findAlbumByName(@Param("name")String name);
}

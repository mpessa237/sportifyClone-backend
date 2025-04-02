package com.example.demo.spotifyClone.repository;

import com.example.demo.spotifyClone.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepo extends JpaRepository<Artist,Integer> {
    @Query("SELECT a FROM Artist a WHERE a.nameArtist=:nameArtist")
    Optional<Artist> findArtistByNameArtist(@Param("nameArtist")String nameArtist);
}

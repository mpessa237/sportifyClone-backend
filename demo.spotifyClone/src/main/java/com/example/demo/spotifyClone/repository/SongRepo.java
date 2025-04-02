package com.example.demo.spotifyClone.repository;

import com.example.demo.spotifyClone.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepo extends JpaRepository<Song,Integer> {
    @Query("SELECT s FROM Song s WHERE s.title=:title")
    Optional<Song> findSongByTitle(@Param("title")String title);
}

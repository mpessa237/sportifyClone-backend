package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.artist.SongReqDTO;
import com.example.demo.spotifyClone.dto.artist.SongRespDTO;
import com.example.demo.spotifyClone.entity.Song;

import java.util.List;

public interface SongService {
    SongRespDTO addSong(SongReqDTO songReqDTO);
    List<Song> getAllSong();
    SongRespDTO getSongById(Integer songId);
    Song getSongByTitle(String title);
    Song updateSong(Song song,Integer songId);
    void deleteSong(Integer songId);
}

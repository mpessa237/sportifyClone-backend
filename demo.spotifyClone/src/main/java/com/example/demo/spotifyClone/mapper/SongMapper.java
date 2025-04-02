package com.example.demo.spotifyClone.mapper;

import com.example.demo.spotifyClone.dto.artist.SongReqDTO;
import com.example.demo.spotifyClone.dto.artist.SongRespDTO;
import com.example.demo.spotifyClone.entity.Artist;
import com.example.demo.spotifyClone.entity.Song;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {
    public Song toEntity(SongReqDTO songReqDTO){
        Song song = new Song();
        song.setTitle(songReqDTO.getTitle());
        
        return song;
    }

    public SongRespDTO toDto(Song song){
        SongRespDTO songRespDTO = new SongRespDTO();
        songRespDTO.setSongId(song.getSongId());
        songRespDTO.setTitle(song.getTitle());

        return songRespDTO;
    }
}

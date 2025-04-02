package com.example.demo.spotifyClone.mapper;

import com.example.demo.spotifyClone.dto.playlist.PlaylistReqDTO;
import com.example.demo.spotifyClone.dto.playlist.PlaylistRespDTO;
import com.example.demo.spotifyClone.entity.Playlist;
import com.example.demo.spotifyClone.entity.User;
import org.springframework.stereotype.Component;

@Component
public class PlaylistMapper {

    public Playlist toEntity(PlaylistReqDTO playlistReqDTO){
        Playlist playlist = new Playlist();
        playlist.setName(playlistReqDTO.getName());

        if (playlistReqDTO.getUserId()!=null){
            User user = new User();
            user.setUserId(playlistReqDTO.getUserId());
            playlist.setUser(user);
        }

        return playlist;
    }

    public PlaylistRespDTO toDto(Playlist playlist){
        PlaylistRespDTO playlistRespDTO = new PlaylistRespDTO();
        playlistRespDTO.setPlaylistId(playlist.getPlaylistId());
        playlistRespDTO.setName(playlist.getName());

        if (playlist.getUser()!=null){
            playlistRespDTO.setUserId(playlist.getUser().getUserId());
        }
        return playlistRespDTO;
    }
}

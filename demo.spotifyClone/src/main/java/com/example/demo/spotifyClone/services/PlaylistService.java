package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.playlist.PlaylistReqDTO;
import com.example.demo.spotifyClone.dto.playlist.PlaylistRespDTO;
import com.example.demo.spotifyClone.entity.Playlist;

import java.util.List;

public interface PlaylistService {
    PlaylistRespDTO addPlaylist(PlaylistReqDTO playlistReqDTO);
    List<Playlist> getAllPlaylist();
    PlaylistRespDTO getPlaylistById(Integer playlistId);
    Playlist getPlaylistByName(String name);
    Playlist updatePlaylist(Playlist playlist,Integer playlistId);
    void deletePlaylistById(Integer playlistId);
}

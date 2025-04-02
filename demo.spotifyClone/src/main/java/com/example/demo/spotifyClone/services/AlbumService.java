package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.artist.AlbumReqDTO;
import com.example.demo.spotifyClone.dto.artist.AlbumRespDTO;
import com.example.demo.spotifyClone.entity.Album;

import java.util.List;

public interface AlbumService {
    AlbumRespDTO addAlbum(AlbumReqDTO albumReqDTO);
    List<Album> getAllAlbum();
    AlbumRespDTO getAlbumById(Integer albumId);
    Album getAlbumByName(String name);
    Album updateAlbumById(Album album,Integer albumId);
    void deleteAlbum(Integer albumId);
}

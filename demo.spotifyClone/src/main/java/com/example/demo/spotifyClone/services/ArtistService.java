package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.artist.ArtistReqDTO;
import com.example.demo.spotifyClone.dto.artist.ArtistRespDTO;
import com.example.demo.spotifyClone.entity.Artist;

import java.util.List;

public interface ArtistService {
    ArtistRespDTO addArtist(ArtistReqDTO artistReqDTO);
    List<Artist> getAllArtist();
    ArtistRespDTO getArtistById(Integer artistId);
    Artist getArtistByNameArtist(String nameArtist);
    Artist updateArtist(Artist artist,Integer artistId);
    void deleteArtistById(Integer artistId);

}

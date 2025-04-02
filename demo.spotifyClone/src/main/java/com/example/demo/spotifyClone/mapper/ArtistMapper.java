package com.example.demo.spotifyClone.mapper;

import com.example.demo.spotifyClone.dto.artist.ArtistReqDTO;
import com.example.demo.spotifyClone.dto.artist.ArtistRespDTO;
import com.example.demo.spotifyClone.entity.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {
    public Artist toEntity(ArtistReqDTO artistRespDTO){
        Artist artist = new Artist();
        artist.setNameArtist(artistRespDTO.getNameArtist());
        artist.setBiography(artistRespDTO.getBiography());
        return artist;

    }

    public ArtistRespDTO toDto(Artist artist){
        ArtistRespDTO artistRespDTO = new ArtistRespDTO();
        artistRespDTO.setArtistId(artist.getArtistId());
        artistRespDTO.setNameArtist(artist.getNameArtist());
        artistRespDTO.setBiography(artist.getBiography());

        return artistRespDTO;
    }
}

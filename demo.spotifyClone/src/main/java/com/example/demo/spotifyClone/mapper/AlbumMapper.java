package com.example.demo.spotifyClone.mapper;

import com.example.demo.spotifyClone.dto.artist.AlbumReqDTO;
import com.example.demo.spotifyClone.dto.artist.AlbumRespDTO;
import com.example.demo.spotifyClone.entity.Album;
import com.example.demo.spotifyClone.entity.Artist;
import com.example.demo.spotifyClone.exception.ResourceNotFoundException;
import com.example.demo.spotifyClone.repository.ArtistRepo;
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {
    private final ArtistRepo artistRepo;

    public AlbumMapper(ArtistRepo artistRepo) {
        this.artistRepo = artistRepo;
    }

    public Album toEntity(AlbumReqDTO albumReqDTO) {
        Album album = new Album();
        album.setName(albumReqDTO.getName());

        if (albumReqDTO.getArtistId() != null) {
            Artist artist = this.artistRepo.findById(albumReqDTO.getArtistId())
                    .orElseThrow(() -> new ResourceNotFoundException("artist not found!!"));
            album.setArtist(artist);
        }
        return album;
    }

    public AlbumRespDTO toDto(Album album) {
        AlbumRespDTO albumRespDTO = new AlbumRespDTO();
        albumRespDTO.setAlbumId(album.getAlbumId());
        albumRespDTO.setName(album.getName());

        if (album.getArtist() != null) {
            albumRespDTO.setArtistId(album.getArtist().getArtistId());
        }

        return albumRespDTO;
    }
}

package com.example.demo.spotifyClone.dto.artist;

import lombok.Data;

@Data
public class AlbumRespDTO {
    private Integer albumId;
    private String name;
    private Integer artistId;
    public Integer getAlbumId() {
        return albumId;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = this.artistId;
    }


    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

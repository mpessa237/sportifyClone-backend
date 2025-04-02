package com.example.demo.spotifyClone.dto.artist;

import lombok.Data;

@Data
public class ArtistRespDTO {
    private Integer artistId;
    private String nameArtist;
    private String biography;

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}

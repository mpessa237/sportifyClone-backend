package com.example.demo.spotifyClone.dto.artist;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ArtistReqDTO {
    @NotEmpty(message = "the field is required")
    private String nameArtist;
    private String biography;


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

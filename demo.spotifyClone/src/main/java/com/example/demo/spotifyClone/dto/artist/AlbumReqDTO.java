package com.example.demo.spotifyClone.dto.artist;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AlbumReqDTO {
    @Length(min = 2,message = "the position name must have at least 2 characters")
    @NotEmpty(message = "the field is required")
    private String name;
    private Integer artistId;

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

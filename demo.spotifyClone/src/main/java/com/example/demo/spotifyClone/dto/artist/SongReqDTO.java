package com.example.demo.spotifyClone.dto.artist;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SongReqDTO {
    @NotEmpty(message = "the field is required")
    private String title;
    private Double duration;
    private Integer artistId;

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

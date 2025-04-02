package com.example.demo.spotifyClone.dto.playlist;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PlaylistReqDTO {
    @NotEmpty(message = "the field is required")
    private String name;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

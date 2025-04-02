package com.example.demo.spotifyClone.controllers;

import com.example.demo.spotifyClone.dto.playlist.PlaylistReqDTO;
import com.example.demo.spotifyClone.dto.playlist.PlaylistRespDTO;
import com.example.demo.spotifyClone.entity.Playlist;
import com.example.demo.spotifyClone.services.PlaylistService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    @ResponseBody
    @PostMapping(path = "playlist/add")
    public ResponseEntity<PlaylistRespDTO> addPlaylist(@Valid @RequestBody PlaylistReqDTO playlistReqDTO){

        PlaylistRespDTO addPlaylist = this.playlistService.addPlaylist(playlistReqDTO);
        return new ResponseEntity<>(addPlaylist, HttpStatus.CREATED);
    }
    @GetMapping(path = "playlist/get-all-playlist")
    public ResponseEntity<List<Playlist>> getAllPlaylist(){
        return ResponseEntity
                .ok(this.playlistService.getAllPlaylist());
    }
    @GetMapping(path = "playlist/get-playlist-by-id/{playlistId}")
    public ResponseEntity<PlaylistRespDTO> getPlaylistById(@PathVariable Integer playlistId){
        return ResponseEntity
                .ok(this.playlistService.getPlaylistById(playlistId));

    }
    @GetMapping(path = "playlist/get-playlist-by-name/{name}")
    public ResponseEntity<Playlist> getPlaylistByName(@PathVariable String name){
        return ResponseEntity
                .ok(this.playlistService.getPlaylistByName(name));
    }
    @PutMapping(path = "playlist/update-playlist-by-id/{playlistId}")
    public ResponseEntity<Playlist> updatePlaylist(@Valid @RequestBody Playlist playlist, @PathVariable Integer playlistId){
        return ResponseEntity
                .ok(this.playlistService.updatePlaylist(playlist, playlistId));
    }
    @DeleteMapping(path = "playlist/delete-playlist/{playlistId}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Integer playlistId){
        this.playlistService.deletePlaylistById(playlistId);
        return ResponseEntity
                .ok("playlist deleted successfully!!");
    }
}

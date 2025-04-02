package com.example.demo.spotifyClone.controllers;

import com.example.demo.spotifyClone.dto.artist.SongReqDTO;
import com.example.demo.spotifyClone.dto.artist.SongRespDTO;
import com.example.demo.spotifyClone.entity.Song;
import com.example.demo.spotifyClone.services.SongService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @ResponseBody
    @PostMapping(path = "song/add")
    public ResponseEntity<SongRespDTO> addsong(@Valid @RequestBody SongReqDTO songReqDTO){
        SongRespDTO addSong = this.songService.addSong(songReqDTO);
        return new ResponseEntity<>(addSong, HttpStatus.CREATED);
    }
    @GetMapping(path = "song/get-all-song")
    public ResponseEntity<List<Song>> getAllSong(){
        return ResponseEntity
                .ok(this.songService.getAllSong());
    }
    @GetMapping(path = "song/get-song-by-id/{songId}")
    public ResponseEntity<SongRespDTO> getSongById(@PathVariable Integer songId){
        return ResponseEntity
                .ok(this.songService.getSongById(songId));
    }
    @GetMapping(path = "song/get-song-by-title/{title}")
    public ResponseEntity<Song> getSongByTitle(@PathVariable String title){
        return ResponseEntity
                .ok(this.songService.getSongByTitle(title));
    }
    @PutMapping(path = "song/update-song-by-id/{songId}")
    public ResponseEntity<Song> updateSong(@Valid @RequestBody Song song,@PathVariable Integer songId){
        return ResponseEntity
                .ok(this.songService.updateSong(song, songId));
    }
    @DeleteMapping(path = "song/delete-song/{songId}")
    public ResponseEntity<String> deleteSong(@PathVariable Integer songId){
        this.songService.deleteSong(songId);
        return ResponseEntity.ok("song deleted successfully!!");
    }
}

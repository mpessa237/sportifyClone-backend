package com.example.demo.spotifyClone.controllers;

import com.example.demo.spotifyClone.dto.artist.AlbumReqDTO;
import com.example.demo.spotifyClone.dto.artist.AlbumRespDTO;
import com.example.demo.spotifyClone.entity.Album;
import com.example.demo.spotifyClone.services.AlbumService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }
    @ResponseBody
    @PostMapping(path = "album/add")
    public ResponseEntity<AlbumRespDTO> addAlbum(@Valid @RequestBody AlbumReqDTO albumReqDTO){
        AlbumRespDTO addAlbum = this.albumService.addAlbum(albumReqDTO);
        return new ResponseEntity<>(addAlbum, HttpStatus.CREATED);
    }
    @GetMapping(path = "album/get-all-album")
    public ResponseEntity<List<Album>> getAllAlbum(){
        return ResponseEntity
                .ok(this.albumService.getAllAlbum());
    }
    @GetMapping(path = "album/get-album-by-id/{albumId}")
    public ResponseEntity<AlbumRespDTO> getAlbumById(@PathVariable Integer albumId){
        return ResponseEntity
                .ok(this.albumService.getAlbumById(albumId));
    }
    @GetMapping(path = "album/get-album-by-name/{name}")
    public ResponseEntity<Album> getAlbumByName(@PathVariable String name){
        return ResponseEntity
                .ok(this.albumService.getAlbumByName(name));
    }
    @PutMapping(path = "album/update-album-by-id/{albumId}")
    public ResponseEntity<Album> updateAlbumById(@Valid @RequestBody Album album,@PathVariable Integer albumId){
        return ResponseEntity
                .ok(this.albumService.updateAlbumById(album, albumId));
    }
    @DeleteMapping(path = "album/delete-album-by-id/{albumId}")
    public ResponseEntity<String> deleteAlbumById(@PathVariable Integer albumId){
        this.albumService.deleteAlbum(albumId);
        return ResponseEntity.ok("album deleted successfully!!");
    }
}

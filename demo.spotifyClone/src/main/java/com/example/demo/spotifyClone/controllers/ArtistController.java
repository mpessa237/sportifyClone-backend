package com.example.demo.spotifyClone.controllers;

import com.example.demo.spotifyClone.dto.artist.ArtistReqDTO;
import com.example.demo.spotifyClone.dto.artist.ArtistRespDTO;
import com.example.demo.spotifyClone.entity.Artist;
import com.example.demo.spotifyClone.services.ArtistService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }
    @ResponseBody
    @PostMapping(path = "artist/add")
    public ResponseEntity<ArtistRespDTO> addArtist(@Valid @RequestBody ArtistReqDTO artistReqDTO){
        ArtistRespDTO addArtist = this.artistService.addArtist(artistReqDTO);
        return new ResponseEntity<>(addArtist, HttpStatus.CREATED);
    }
    @GetMapping(path = "artist/get-all-artist")
    public ResponseEntity<List<Artist>> getAllArtist(){
        return ResponseEntity
                .ok(this.artistService.getAllArtist());
    }
    @GetMapping(path = "artist/get-artist-by-id/{artistId}")
    public ResponseEntity<ArtistRespDTO> getArtistById(@PathVariable Integer artistId){
return ResponseEntity
        .ok(this.artistService.getArtistById(artistId));
    }
    @GetMapping(path = "artist/get-artist-by-name-artist/{nameArtist}")
    public ResponseEntity<Artist> getArtistByNameArtist(@PathVariable String nameArtist){
        return ResponseEntity
                .ok(this.artistService.getArtistByNameArtist(nameArtist));
    }
    @PutMapping(path = "artist/update-artist-by-id/{artistId}")
    public ResponseEntity<Artist> updateArtist(@Valid @RequestBody Artist artist,@PathVariable Integer artistId){
        return ResponseEntity
                .ok(this.artistService.updateArtist(artist, artistId));
    }
    @DeleteMapping(path = "artist/delete-artist/{artistId}")
    public ResponseEntity<String> deleteArtist(@PathVariable Integer artistId){
        this.artistService.deleteArtistById(artistId);
        return ResponseEntity.ok("artist deleted successfully!!");
    }
}

package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.artist.ArtistReqDTO;
import com.example.demo.spotifyClone.dto.artist.ArtistRespDTO;
import com.example.demo.spotifyClone.entity.Artist;
import com.example.demo.spotifyClone.exception.ResourceNotFoundException;
import com.example.demo.spotifyClone.mapper.ArtistMapper;
import com.example.demo.spotifyClone.repository.ArtistRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService{
    private final ArtistRepo artistRepo;
    private final ArtistMapper artistMapper;

    public ArtistServiceImpl(ArtistRepo artistRepo, ArtistMapper artistMapper) {
        this.artistRepo = artistRepo;
        this.artistMapper = artistMapper;
    }

    @Override
    public ArtistRespDTO addArtist(ArtistReqDTO artistReqDTO) {

        Artist artist = this.artistMapper.toEntity(artistReqDTO);
        Artist addArtist = this.artistRepo.save(artist);
        return this.artistMapper.toDto(addArtist);

    }

    @Override
    public List<Artist> getAllArtist() {
        return this.artistRepo.findAll();
    }

    @Override
    public ArtistRespDTO getArtistById(Integer artistId) {
        Artist artist = this.artistRepo.findById(artistId)
                .orElseThrow(()-> new ResourceNotFoundException("artist not found!!"));
        return this.artistMapper.toDto(artist);
    }

    @Override
    public Artist getArtistByNameArtist(String nameArtist) {
        Optional<Artist> artist = this.artistRepo.findArtistByNameArtist(nameArtist);
        if (artist.isEmpty())
            throw new ResourceNotFoundException("artist not found!!");
        return artist.get();
    }

    @Override
    public Artist updateArtist(Artist artist, Integer artistId) {

        Optional<Artist> artistOptional = this.artistRepo.findById(artistId);
        if (artistOptional.isEmpty())
            throw new ResourceNotFoundException("artist not found!!");
        if (artist.getNameArtist()!=null)
            artistOptional.get().setNameArtist(artist.getNameArtist());
        if (artist.getBiography()!=null)
            artistOptional.get().setBiography(artist.getBiography());

        return this.artistRepo.saveAndFlush(artistOptional.get());
    }

    @Override
    public void deleteArtistById(Integer artistId) {
        this.artistRepo.delete(this.artistRepo.findById(artistId)
                .orElseThrow(()->new ResourceNotFoundException("artist not found!!")));
    }
}

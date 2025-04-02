package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.artist.AlbumReqDTO;
import com.example.demo.spotifyClone.dto.artist.AlbumRespDTO;
import com.example.demo.spotifyClone.entity.Album;
import com.example.demo.spotifyClone.exception.ResourceNotFoundException;
import com.example.demo.spotifyClone.mapper.AlbumMapper;
import com.example.demo.spotifyClone.repository.AlbumRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService{
    private final AlbumMapper albumMapper;
    private final AlbumRepo albumRepo;

    public AlbumServiceImpl(AlbumMapper albumMapper, AlbumRepo albumRepo) {
        this.albumMapper = albumMapper;
        this.albumRepo = albumRepo;
    }

    @Override
    public AlbumRespDTO addAlbum(AlbumReqDTO albumReqDTO) {
        Album album = this.albumMapper.toEntity(albumReqDTO);
        Album addAlbum = this.albumRepo.save(album);

        if (addAlbum.getArtist() != null) {
            addAlbum.getArtist().getArtistId();  // Accéder à l'artiste pour activer le lazy loading
        }
        return this.albumMapper.toDto(addAlbum);
    }

    @Override
    public List<Album> getAllAlbum() {
        return this.albumRepo.findAll();
    }

    @Override
    public AlbumRespDTO getAlbumById(Integer albumId) {
        Album album = this.albumRepo.findById(albumId)
                .orElseThrow(()-> new ResourceNotFoundException("album not found!"));
        return this.albumMapper.toDto(album);
    }

    @Override
    public Album getAlbumByName(String name) {
        Optional<Album> album = this.albumRepo.findAlbumByName(name);
        if (album.isEmpty())
            throw new ResourceNotFoundException("album not found!!");
        return album.get();
    }

    @Override
    public Album updateAlbumById(Album album, Integer albumId) {
        Optional<Album> albumOptional = this.albumRepo.findById(albumId);
        if (albumOptional.isEmpty())
            throw new ResourceNotFoundException("album not found!!");
        if (album.getName()!=null)
            albumOptional.get().setName(album.getName());

        return this.albumRepo.saveAndFlush(albumOptional.get());
    }

    @Override
    public void deleteAlbum(Integer albumId) {
        this.albumRepo.delete(this.albumRepo.findById(albumId)
                .orElseThrow(()-> new ResourceNotFoundException("album not found!")));
    }
}

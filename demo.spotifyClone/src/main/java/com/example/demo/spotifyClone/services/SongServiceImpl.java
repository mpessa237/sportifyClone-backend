package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.artist.SongReqDTO;
import com.example.demo.spotifyClone.dto.artist.SongRespDTO;
import com.example.demo.spotifyClone.entity.Song;
import com.example.demo.spotifyClone.exception.ResourceNotFoundException;
import com.example.demo.spotifyClone.mapper.SongMapper;
import com.example.demo.spotifyClone.repository.SongRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{
    private final SongRepo songRepo;
    private final SongMapper songMapper;

    public SongServiceImpl(SongRepo songRepo, SongMapper songMapper) {
        this.songRepo = songRepo;
        this.songMapper = songMapper;
    }

    @Override
    public SongRespDTO addSong(SongReqDTO songReqDTO) {
        Song song = this.songMapper.toEntity(songReqDTO);
        Song addSong = this.songRepo.save(song);
        return this.songMapper.toDto(addSong);
    }

    @Override
    public List<Song> getAllSong() {
        return this.songRepo.findAll();
    }

    @Override
    public SongRespDTO getSongById(Integer songId) {
        Song song = this.songRepo.findById(songId)
                .orElseThrow(()-> new ResourceNotFoundException("song not found!!"));
        return this.songMapper.toDto(song);
    }

    @Override
    public Song getSongByTitle(String title) {
        Optional<Song> song = this.songRepo.findSongByTitle(title);
        if (song.isEmpty())
            throw new ResourceNotFoundException("song not found!!");
        return song.get();
    }

    @Override
    public Song updateSong(Song song, Integer songId) {
        Optional<Song> songOptional = this.songRepo.findById(songId);
        if (songOptional.isEmpty())
            throw new ResourceNotFoundException("song not found!!");
        if (song.getTitle()!=null)
            songOptional.get().setTitle(song.getTitle());
        if (song.getDuration()!=null)
            songOptional.get().setDuration(song.getDuration());

        return this.songRepo.saveAndFlush(songOptional.get());
    }

    @Override
    public void deleteSong(Integer songId) {
        this.songRepo.delete(this.songRepo.findById(songId)
                .orElseThrow(()-> new ResourceNotFoundException("song not found!!")));

    }
}

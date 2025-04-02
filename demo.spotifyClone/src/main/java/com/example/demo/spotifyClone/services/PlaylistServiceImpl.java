package com.example.demo.spotifyClone.services;

import com.example.demo.spotifyClone.dto.playlist.PlaylistReqDTO;
import com.example.demo.spotifyClone.dto.playlist.PlaylistRespDTO;
import com.example.demo.spotifyClone.entity.Playlist;
import com.example.demo.spotifyClone.exception.ResourceNotFoundException;
import com.example.demo.spotifyClone.mapper.PlaylistMapper;
import com.example.demo.spotifyClone.repository.PlaylistRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{
    private final PlaylistRepo playlistRepo;
    private final PlaylistMapper playlistMapper;

    public PlaylistServiceImpl(PlaylistRepo playlistRepo, PlaylistMapper playlistMapper) {
        this.playlistRepo = playlistRepo;
        this.playlistMapper = playlistMapper;
    }

    @Override
    public PlaylistRespDTO addPlaylist(PlaylistReqDTO playlistReqDTO) {
        Playlist playlist = this.playlistMapper.toEntity(playlistReqDTO);
        Playlist addPlaylist = this.playlistRepo.save(playlist);

        return this.playlistMapper.toDto(addPlaylist);
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return this.playlistRepo.findAll();
    }

    @Override
    public PlaylistRespDTO getPlaylistById(Integer playlistId) {

        Playlist playlist = this.playlistRepo.findById(playlistId)
        .orElseThrow(()-> new ResourceNotFoundException("playlist not found!!"));
        return this.playlistMapper.toDto(playlist);
    }

    @Override
    public Playlist getPlaylistByName(String name) {
        Optional<Playlist> playlist = this.playlistRepo.findPlaylistByName(name);
        if (playlist.isEmpty())
            throw new ResourceNotFoundException("playlist not found!!");
        return playlist.get();
    }

    @Override
    public Playlist updatePlaylist(Playlist playlist, Integer playlistId) {
        Optional<Playlist> playlistOptional = this.playlistRepo.findById(playlistId);
        if (playlistOptional.isEmpty())
            throw new ResourceNotFoundException("playlist not found!!");
        if (playlist.getName()!=null)
            playlistOptional.get().setName(playlist.getName());

        return this.playlistRepo.saveAndFlush(playlistOptional.get());
    }

    @Override
    public void deletePlaylistById(Integer playlistId) {

        this.playlistRepo.delete(this.playlistRepo.findById(playlistId)
                .orElseThrow(()-> new ResourceNotFoundException("playlist not found!!")));
    }
}

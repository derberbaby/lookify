package com.debbie.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.debbie.lookify.models.Song;
import com.debbie.lookify.repositories.SongRepo;

@Service
public class SongService {
	private SongRepo songRepo;
	
	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}
	
	public List<Song> allSongs() {
		return (List<Song>) songRepo.findAll();
	}
	
	public Song findSongById(Long id) {
		return songRepo.findOne(id);
	}
	
	public void addSong(Song song) {
		songRepo.save(song);
	}
	
	public void updateSong(Song song) {
		songRepo.save(song);
	}
	
	public void destroySong(Long id) {
		songRepo.delete(id);
	}
	
	public List<Song> findTopSongs() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
	
	public List<Song> findByArtist(String search) {
		return songRepo.findByArtistContaining(search);
	}
}

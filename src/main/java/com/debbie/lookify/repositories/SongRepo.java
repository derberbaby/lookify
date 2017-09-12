package com.debbie.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.debbie.lookify.models.Song;

public interface SongRepo extends CrudRepository<Song, Long> {
	List<Song> findByArtistContaining(String search);
	List<Song> findTop10ByOrderByRatingDesc();
}

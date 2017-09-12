package com.debbie.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.debbie.lookify.models.Song;
import com.debbie.lookify.services.SongService;

@Controller
public class SongController {

	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dash";
	}
	
	@RequestMapping("/songs/{id}")
	public String findSongById(Model model, @PathVariable("id") Long id) {
		model.addAttribute("song", songService.findSongById(id));
		return "showSong";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "newSong";
	}
	
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong";
		} else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/delete/{id}")
	public String destroySong(@PathVariable("id") Long id) {
		songService.destroySong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/songs/top")
	public String topSongs(Model model) {
		model.addAttribute("songs", songService.findTopSongs());
		return "topSongs";
	}
	
	@PostMapping("/search")
	public String findByArtist(Model model, @RequestParam("searchQuery") String search) {
		model.addAttribute("songs", songService.findByArtist(search));
		model.addAttribute("searchedArtist", search);
		return "searched";
	}

}

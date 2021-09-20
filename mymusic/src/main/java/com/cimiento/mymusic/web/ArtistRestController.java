package com.cimiento.mymusic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cimiento.mymusic.dto.ArtistDto;
import com.cimiento.mymusic.service.ArtistService;

@RestController
@RequestMapping(value="/rest")
public class ArtistRestController {
	
	@Autowired
	private ArtistService artistService;
	
	@GetMapping(value="/getAllArtists")
	public ResponseEntity<List<ArtistDto>> getAllArtists() {
		List<ArtistDto> artists = artistService.getAllArtists();
		return new ResponseEntity<List<ArtistDto>>(artists, HttpStatus.OK);
	}
	
	@GetMapping(value="/artist/{id}")
	public ResponseEntity<ArtistDto> getArtist(@PathVariable Integer id) {	
		ArtistDto artist = artistService.getArtist(id);
		return new ResponseEntity<ArtistDto>(artist,HttpStatus.OK);
	}
	
	@PostMapping(value="/createArtist")
	public ResponseEntity<ArtistDto> createArtist(@RequestBody ArtistDto artist) {	
		artistService.saveArtist(artist);
		return new ResponseEntity<ArtistDto>(artist,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/saveArtist")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ArtistDto> saveArtist(@RequestBody ArtistDto artist) {	
		artistService.saveArtist(artist);
		return new ResponseEntity<ArtistDto>(artist,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteArtist/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Integer> deleteArtist(@PathVariable Integer id) {	
		artistService.deleteArtist(id);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
}

package com.cimiento.mymusic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cimiento.mymusic.dto.ArtistDto;
import com.cimiento.mymusic.service.ArtistService;

@RestController
public class ArtistRestController {
	
	@Autowired
	private ArtistService artistService;
	
	@RequestMapping(value="/rest/getAllArtists",  method = RequestMethod.GET)
	public ResponseEntity<List<ArtistDto>> getAllArtists() {
		List<ArtistDto> artists = artistService.getAllArtists();
		return new ResponseEntity<List<ArtistDto>>(artists, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/artist/{id}",  method = RequestMethod.GET)
	public ResponseEntity<ArtistDto> getArtist(@PathVariable Integer id) {	
		ArtistDto artist = artistService.getArtist(id);
		return new ResponseEntity<ArtistDto>(artist,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/createArtist",  method = RequestMethod.POST)
	public ResponseEntity<ArtistDto> createArtist(@RequestBody ArtistDto artist) {	
		artistService.saveArtist(artist);
		return new ResponseEntity<ArtistDto>(artist,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/saveArtist",  method = RequestMethod.PUT)
	public ResponseEntity<ArtistDto> saveArtist(@RequestBody ArtistDto artist) {	
		artistService.saveArtist(artist);
		return new ResponseEntity<ArtistDto>(artist,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/deleteArtist/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteArtist(@PathVariable Integer id) {	
		artistService.deleteArtist(id);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
}

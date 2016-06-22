package com.cimiento.mymusic.service;

import java.util.List;

import com.cimiento.mymusic.dto.ArtistDto;

public interface ArtistService {
	List<ArtistDto> getAllArtists();
	ArtistDto getArtist(Integer id);
	void saveArtist(ArtistDto artistDto);
	void deleteArtist(Integer id);
}

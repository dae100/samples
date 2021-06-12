package com.cimiento.mymusic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cimiento.mymusic.dto.ArtistDto;
import com.cimiento.mymusic.entity.Artist;
import com.cimiento.mymusic.repository.ArtistRepository;
import com.cimiento.mymusic.util.EntityTransformer;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtistRepository artistRepo;
	
	@Override
	public List<ArtistDto> getAllArtists() {	
		List<Artist> artists = artistRepo.findAll();
		List<ArtistDto> artistDtos = new ArrayList<ArtistDto>();
		
		for(Artist artist : artists) 
		{
			ArtistDto dto = EntityTransformer.transformToArtistDto(artist);
			artistDtos.add(dto);
		}
		
		return artistDtos;
	}

	@Override
	public ArtistDto getArtist(Integer id) {
		Optional<Artist> artist = artistRepo.findById(id);
		ArtistDto dto = null;
		
		if (artist.isPresent()) {
			dto = EntityTransformer.transformToArtistDto(artist.get());
		}
		
		return dto;
	}

	@Override
	public void saveArtist(ArtistDto artistDto) {		
		Artist artist = EntityTransformer.transformToArtist(artistDto);
		artistRepo.saveAndFlush(artist);
		if (artistDto.getId() == null) artistDto.setId(artist.getId());	
	}

	@Override
	public void deleteArtist(Integer id) {		
		artistRepo.deleteById(id);
		artistRepo.flush();
	}

}

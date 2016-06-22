package com.cimiento.mymusic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cimiento.mymusic.entity.Artist;
import com.cimiento.mymusic.repository.ArtistRepository;

@Controller
public class Hello {

	@Autowired
	private ArtistRepository artistRepo;
	
	
	@RequestMapping(value="/greetings", method = RequestMethod.GET )
	public String sayHello() {
		List<Artist> list = artistRepo.findAll();
		
		for(Artist artist: list) {
			System.out.println(artist.getName());
		}
				
		return "hello";
	}
}

package com.cimiento.mymusic.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cimiento.mymusic.entity.Artist;
import com.cimiento.mymusic.entity.Product;
import com.cimiento.mymusic.entity.RecordLabel;
import com.cimiento.mymusic.repository.ArtistRepository;
import com.cimiento.mymusic.repository.ProductRepository;
import com.cimiento.mymusic.repository.RecordLabelRepository;

@Service
public class DbInitializer {

	@Autowired
	private ArtistRepository artistRepo;
	
	@Autowired
	private RecordLabelRepository publisherRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@PostConstruct
	public void initDb() {
		
		
		// Check if records have already been initialized
		// If none, then initialize the data
		Optional<Artist> artist = artistRepo.findById(1);
		
		if (artist.isEmpty())
		{
			Artist art1 = new Artist("The Merchants of Venus", "Indie band");
			Artist art2 = new Artist("Chuck Berry", "50's guitarist and singer.");
			Artist art3 = new Artist("Teddy Wilson", "Jazz pianist");
			RecordLabel pub1 = new RecordLabel("Venus Records", "Indie label.");
			RecordLabel pub2 = new RecordLabel("Berry Records", "Rock and roll label");
			RecordLabel pub3 = new RecordLabel("Combotone Records", "Jazz label.");
			Product prod1 = new Product("Paradise in Texas", "Single with b-side", art1, pub1);
			Product prod2 = new Product("Rock and Roll Music", "Album", art2, pub2);
			Product prod3 = new Product("What A Little Moonlight Can Do", "Album", art3, pub3);
			
			artistRepo.save(art1);
			artistRepo.save(art2);
			artistRepo.save(art3);
			publisherRepo.save(pub1);		
			publisherRepo.save(pub2);
			publisherRepo.save(pub3);
			prodRepo.save(prod1);
			prodRepo.save(prod2);
			prodRepo.save(prod3);
			
			artistRepo.flush();
			publisherRepo.flush();
			prodRepo.flush();
		}
		List<Product> list = prodRepo.findAllWithArtistAndRecordLabel();
				
		for(Product prod: list) {
			System.out.println(prod.getArtist().getName());
		}
	}
}

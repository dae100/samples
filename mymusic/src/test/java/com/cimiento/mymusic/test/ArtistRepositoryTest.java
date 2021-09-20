package com.cimiento.mymusic.test;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cimiento.mymusic.entity.Artist;
import com.cimiento.mymusic.repository.ArtistRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Transactional
@Rollback
public class ArtistRepositoryTest {

    @Autowired
    ArtistRepository repository;
    
    @Test
    public void testArtistRepository() {
        Optional<Artist> artist = repository.findById(1);
        assertTrue(artist != null);
    }
     
    

}

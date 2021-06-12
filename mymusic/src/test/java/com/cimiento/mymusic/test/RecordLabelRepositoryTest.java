package com.cimiento.mymusic.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cimiento.mymusic.entity.RecordLabel;
import com.cimiento.mymusic.repository.RecordLabelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/core-context.xml"})
@Transactional
@Rollback
public class RecordLabelRepositoryTest {

	@Autowired
	private RecordLabelRepository recordLabelRepository;
	
	@Test
	public void test() {
		Optional<RecordLabel> label = recordLabelRepository.findById(1);
		assertTrue(label != null);
	}

}

package com.cimiento.mymusic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cimiento.mymusic.dto.RecordLabelDto;
import com.cimiento.mymusic.entity.RecordLabel;
import com.cimiento.mymusic.repository.RecordLabelRepository;
import com.cimiento.mymusic.util.EntityTransformer;

@Service
public class RecordLabelServiceImpl implements RecordLabelService {

	@Autowired
	private RecordLabelRepository recordLabelRepo;
	
	@Override
	public List<RecordLabelDto> getAllRecordLabels() {
		List<RecordLabel> recordLabels = recordLabelRepo.findAll();
		List<RecordLabelDto> dtoList = new ArrayList<RecordLabelDto>();
		for(RecordLabel recordLabel : recordLabels) {
			RecordLabelDto dto = EntityTransformer.transformToRecordLabelDto(recordLabel);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Override
	public RecordLabelDto getRecordLabel(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRecordLabel(RecordLabelDto recordLabelDto) {
		RecordLabel recordLabel = EntityTransformer.transformToRecordLabel(recordLabelDto);
		recordLabelRepo.saveAndFlush(recordLabel);
		if (recordLabelDto.getId() == null) recordLabelDto.setId(recordLabel.getId());
	}

	@Override
	public void deleteRecordLabel(Integer id) {
		recordLabelRepo.deleteById(id);
	}

}

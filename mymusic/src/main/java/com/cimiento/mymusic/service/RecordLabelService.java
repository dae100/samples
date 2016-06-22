package com.cimiento.mymusic.service;

import java.util.List;

import com.cimiento.mymusic.dto.RecordLabelDto;

public interface RecordLabelService {
	List<RecordLabelDto> getAllRecordLabels();
	RecordLabelDto getRecordLabel(Integer id);
	void saveRecordLabel(RecordLabelDto recordLabelDto);
	void deleteRecordLabel(Integer id);
}

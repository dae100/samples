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

import com.cimiento.mymusic.dto.RecordLabelDto;
import com.cimiento.mymusic.service.RecordLabelService;

@RestController
public class RecordLabelRestController {
	@Autowired
	private RecordLabelService recordLabelService;
	
	@RequestMapping(value="/rest/getAllRecordLabels",  method = RequestMethod.GET)
	public ResponseEntity<List<RecordLabelDto>> getAllRecordLabels() {
		List<RecordLabelDto> recordLabels = recordLabelService.getAllRecordLabels();
		return new ResponseEntity<List<RecordLabelDto>>(recordLabels, HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/recordLabel/{id}",  method = RequestMethod.GET)
	public ResponseEntity<RecordLabelDto> getRecordLabel(@PathVariable Integer id) {	
		RecordLabelDto recordLabel = recordLabelService.getRecordLabel(id);
		return new ResponseEntity<RecordLabelDto>(recordLabel,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/createRecordLabel",  method = RequestMethod.POST)
	public ResponseEntity<RecordLabelDto> createRecordLabel(@RequestBody RecordLabelDto recordLabel) {	
		recordLabelService.saveRecordLabel(recordLabel);
		return new ResponseEntity<RecordLabelDto>(recordLabel,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/saveRecordLabel",  method = RequestMethod.PUT)
	public ResponseEntity<RecordLabelDto> saveRecordLabel(@RequestBody RecordLabelDto recordLabel) {	
		recordLabelService.saveRecordLabel(recordLabel);
		return new ResponseEntity<RecordLabelDto>(recordLabel,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rest/deleteRecordLabel/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteRecordLabel(@PathVariable Integer id) {	
		recordLabelService.deleteRecordLabel(id);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
}

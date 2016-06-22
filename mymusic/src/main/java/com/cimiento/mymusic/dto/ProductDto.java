package com.cimiento.mymusic.dto;


public class ProductDto {
	
	private Integer id;
	private String title;	
	private String description;
	private ArtistDto artist;
	private RecordLabelDto recordLabel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArtistDto getArtist() {
		return artist;
	}
	public void setArtist(ArtistDto artist) {
		this.artist = artist;
	}
	public RecordLabelDto getRecordLabel() {
		return recordLabel;
	}
	public void setRecordLabel(RecordLabelDto recordLabel) {
		this.recordLabel = recordLabel;
	}
	
}

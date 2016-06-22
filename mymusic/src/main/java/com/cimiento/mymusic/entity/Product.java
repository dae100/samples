package com.cimiento.mymusic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@javax.persistence.Entity
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 50, nullable = false)
	private String title;
	
	@Column(length = 500, nullable = true)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTISTID")
	private Artist artist;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECORDLABELID")
	private RecordLabel recordLabel;

	public Product() {
		
	}
	
	public Product(String title, String description, Artist artist, RecordLabel recordLabel)
	{
		this.title = title;
		this.description = description;
		this.artist = artist;
		this.recordLabel = recordLabel;
	}
	
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

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public RecordLabel getRecordLabel() {
		return recordLabel;
	}

	public void setRecordLabel(RecordLabel recordLabel) {
		this.recordLabel = recordLabel;
	}
	
}

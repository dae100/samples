package com.cimiento.mymusic.util;

import com.cimiento.mymusic.dto.ArtistDto;
import com.cimiento.mymusic.dto.ProductDto;
import com.cimiento.mymusic.dto.RecordLabelDto;
import com.cimiento.mymusic.entity.Artist;
import com.cimiento.mymusic.entity.Product;
import com.cimiento.mymusic.entity.RecordLabel;

public class EntityTransformer {
	
	public static ArtistDto transformToArtistDto(Artist artist) {
		ArtistDto dto = null;
		
		if (artist != null) {
			dto = new ArtistDto();
			dto.setId(artist.getId());
			dto.setName(artist.getName());
			dto.setDescription(artist.getDescription());
		}
		
		return dto;
	}
	
	public static Artist transformToArtist(ArtistDto artistDto) {
		Artist artist = new Artist();
		if (artistDto.getId() != null) {
			artist.setId(artistDto.getId());
		}
		artist.setName(artistDto.getName());
		artist.setDescription(artistDto.getDescription());
		return artist;
	}
	
	public static ProductDto transformToProductDto(Product product) {
		ProductDto dto = null;
		if (product != null) {
			dto = new ProductDto();
			dto.setArtist(transformToArtistDto(product.getArtist()));
			dto.setDescription(product.getDescription());
			dto.setId(product.getId());
			dto.setRecordLabel(transformToRecordLabelDto(product.getRecordLabel()));
			dto.setTitle(product.getTitle());
		}
		return dto;
	}
	
	public static Product transformToProduct(ProductDto productDto) {
		Product dto = null;
		if (productDto != null) {
			dto = new Product();
			dto.setArtist(transformToArtist(productDto.getArtist()));
			dto.setDescription(productDto.getDescription());
			dto.setId(productDto.getId());
			dto.setRecordLabel(transformToRecordLabel(productDto.getRecordLabel()));
			dto.setTitle(productDto.getTitle());
		}
		return dto;
	}
	
	public static RecordLabelDto transformToRecordLabelDto(RecordLabel recordLabel) {
		RecordLabelDto dto = null;
		if (recordLabel != null) {
			dto = new RecordLabelDto();
			dto.setDescription(recordLabel.getDescription());
			dto.setId(recordLabel.getId());
			dto.setName(recordLabel.getName());
		}
		return dto;
	}
	
	public static RecordLabel transformToRecordLabel(RecordLabelDto recordLabelDto) {
		RecordLabel recordLabel = new RecordLabel();
		if (recordLabelDto.getId() != null) {
			recordLabel.setId(recordLabelDto.getId());
		}
		recordLabel.setDescription(recordLabelDto.getDescription());
		recordLabel.setName(recordLabelDto.getName());
		return recordLabel;
	}
}

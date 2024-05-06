package com.romano.image_api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idAuteur;
	@Column(columnDefinition = "DATE")
	private String date;
	private String description;
	@Column(columnDefinition = "TEXT")
	private String imageData;

	public Image() {
	};

	public Image(Long id, String imageData, String description, String date, Long idAuteur) {
		super();
		this.id = id;
		this.setIdAuteur(idAuteur);
		this.description = description;
		this.date = date;
		
		this.imageData = imageData;
	}

	public Long getId() {
		return id;
	}

	public String getImageData() {
		return imageData;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
	}

}

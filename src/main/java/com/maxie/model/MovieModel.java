package com.maxie.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MovieModel {
	private String title;
	private String genre;
	private String description;
	private int rating;
	
	// create option-dropdowns
	private List<String> genreOptions;
	private List<Integer> ratingOptions;
	
	// no arg constructor
	public MovieModel(){
		// populate genre dropdown with options
		genreOptions = new ArrayList<>();
		genreOptions.add("Action");
		genreOptions.add("Comedy");
		genreOptions.add("Documentary");
		genreOptions.add("Drama");
		genreOptions.add("Horror");
		genreOptions.add("Thriller");
		
		// populate ratings dropdown
		ratingOptions = new ArrayList<>();
		for(int i = 1; i <= 10; i++){
			ratingOptions.add(i);
		}
	}
	
	public void reset() {
		this.title = null;
		this.genre = null;
		this.description = null;
	}

	// getters and setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<String> getGenreOptions() {
		return genreOptions;
	}

	public List<Integer> getRatingOptions() {
		return ratingOptions;
	}

}

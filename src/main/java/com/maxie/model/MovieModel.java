package com.maxie.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * ManagedBean for Movie objects
 * 
 * @author Maxie
 *
 */
@ManagedBean
public class MovieModel {
	private String title;
	private String genre;
	private String description;
	private int rating;

	// create option-dropdowns
	private List<String> genreOptions;
	private List<Integer> ratingOptions;

	/**
	 * no args constructor that populates the genre and rating arrays, used in the
	 * jsf form when adding a new movie
	 */
	// no arg constructor
	public MovieModel() {
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
		for (int i = 1; i <= 10; i++) {
			ratingOptions.add(i);
		}
	}

	/**
	 * Resets Movie variables by setting String to null and ints to 0
	 */
	public void reset() {
		this.title = null;
		this.genre = null;
		this.description = null;
		this.rating = 0;
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

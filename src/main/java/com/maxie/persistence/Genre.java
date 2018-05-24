package com.maxie.persistence;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Genre POJO, used in database mapping by hibernate
 * 
 * @author Maxie
 *
 */
@Entity
public class Genre {
	@Id
	@GeneratedValue
	private int genreId;
	private String genre;
	// set if movies for oneToMany mapping
	@OneToMany(mappedBy = "genre")
	private Set<Movie> movies;

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	public String toString() {
		return genre;
	}

}

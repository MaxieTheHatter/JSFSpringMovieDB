package com.maxie.manager;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.maxie.dao.MovieDAO;
import com.maxie.model.MovieModel;
import com.maxie.persistence.User;

/**
 * CDI Bean for movie objects
 * 
 * @author Maxie
 *
 */
@Named
public class MovieManager {

	@Inject
	public MovieDAO movieDAO;

	/**
	 * Tells the DAO to execute an INSERT of a new movie object
	 * 
	 * @param model
	 *            the movieModel containing the Movie ManagedBean
	 */
	public void addMovie(MovieModel model) {
		movieDAO.addMovie(model);
	}

	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	/**
	 * Executes the DAO method which returns a list of movies from the database
	 * 
	 * @return List containing all entered movies in the database
	 * @see MovieDAO#getMovies()
	 */
	public List getMovies() {
		return movieDAO.getMovies();
	}

}

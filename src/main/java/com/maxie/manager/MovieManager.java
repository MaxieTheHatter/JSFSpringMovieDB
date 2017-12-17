package com.maxie.manager;

import javax.inject.Inject;
import javax.inject.Named;

import com.maxie.dao.MovieDAO;
import com.maxie.model.MovieModel;

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

	public void addMovie(MovieModel model) {
		movieDAO.addMovie(model);
	}

	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

}

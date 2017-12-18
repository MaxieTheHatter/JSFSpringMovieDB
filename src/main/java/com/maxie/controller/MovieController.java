package com.maxie.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.maxie.dao.MovieDAO;
import com.maxie.manager.MovieManager;
import com.maxie.model.MovieModel;

/**
 * Controls the model Movie ManagedBean
 * 
 * @author Maxie
 *
 */
@ManagedBean
@Named
public class MovieController {

	// Inject movieManager bean
	@Inject
	public MovieManager movieManager;
	private MovieModel model = new MovieModel();

	/**
	 * Tries to add the model to the movieManager while checking for errors
	 * 
	 * @return redirects the user to confirmation page
	 */
	public String addMovie() {
		try {
			movieManager.addMovie(model);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Registration failed, reason: " + e.getMessage(), ""));
			return null;
		}
		return "movie_confirmation";
	}

	/**
	 * Tells the movie manager to execute the getMovies path, movieManager tells
	 * movieDAO to get the list which is then returned to the controller
	 * 
	 * @return List containing all movie object from the DB table movie
	 * 
	 * @see MovieManager#getMovies()
	 * @see MovieDAO#getMovies()
	 */
	public List getMovies() {
		return movieManager.getMovies();
	}

	// getters and setters
	public MovieModel getModel() {
		return model;
	}

	public void setModel(MovieModel model) {
		this.model = model;
	}

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}

}

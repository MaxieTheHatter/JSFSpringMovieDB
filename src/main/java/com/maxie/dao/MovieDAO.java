package com.maxie.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.maxie.model.MovieModel;
import com.maxie.persistence.Genre;
import com.maxie.persistence.Movie;

/**
 * Data Acess Object class that handles all database operations for user
 * objects. Contains methods to apply CRUD
 * 
 * @author Maxie
 *
 */
@Named
@Transactional("transactionManager")
public class MovieDAO {

	// inject the sessionFactory
	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Creates a movie POJO and sets attributes before saving to database. If
	 * selected genre doesn't exist, add it to database.
	 * 
	 * @param model
	 *            model object retrieved from controller class
	 */
	public void addMovie(MovieModel model) {
		Movie movie = new Movie();
		movie.setTitle(model.getTitle());
		movie.setRating(model.getRating());
		movie.setDescription(model.getDescription());
		Genre genre = (Genre) sessionFactory.getCurrentSession()
				.createQuery("FROM Genre WHERE genre ='" + model.getGenre() + "'").uniqueResult();
		if (genre == null) {
			genre = new Genre();
			genre.setGenre(model.getGenre());
			sessionFactory.getCurrentSession().save(genre);
		}
		movie.setGenre(genre);
		sessionFactory.getCurrentSession().save(movie);
	}

	/**
	 * Executes a HQL query that returns all columns from the movie table
	 * 
	 * @return a list containing all movie entries
	 */
	public List getMovies() {
		return sessionFactory.openSession().createQuery("FROM Movie").list();
	}
}

package com.maxie.dao;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.maxie.model.MovieModel;
import com.maxie.persistence.Genre;
import com.maxie.persistence.Movie;

@Named
@Transactional("transactionManager")
public class MovieDAO {

	// inject the sessionFactory
	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addMovie(MovieModel model) {
		Movie movie = new Movie();
		System.out.println("Movie title: " + movie.getTitle());
		System.out.println("Movie description :" + movie.getDescription());
		System.out.println("Movie rating: " + movie.getRating());
		movie.setTitle(model.getTitle());
		movie.setRating(model.getRating());
		Genre genre = (Genre) sessionFactory.getCurrentSession()
				.createQuery("FROM genre WHERE genre ='" + model.getGenre() + "'").uniqueResult();

		movie.setGenre(genre);
		sessionFactory.getCurrentSession().save(movie);
	}
}

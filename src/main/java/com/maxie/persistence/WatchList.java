package com.maxie.persistence;

public class WatchList {
	private int listId;
	private Integer watched;
	private Movie movie;

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public Integer getWatched() {
		return watched;
	}

	public void setWatched(Integer watched) {
		this.watched = watched;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}

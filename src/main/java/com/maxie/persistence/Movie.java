package com.maxie.persistence;

import java.util.HashSet;
import java.util.Set;

public class Movie {
	private int movieId;
	private String title;
	private String description;
	private Integer enabled;
	private Set<WatchList> watchlists = new HashSet<WatchList>(0);
	private Set<Director> directors = new HashSet<Director>(0);
	private Set<LeadActor> leadActors = new HashSet<LeadActor>(0);

}

package com.nanodegree.mdaniel.popularmovies1.services;

/**
 * Created by florentchampigny on 02/07/15.
 */
public class QueryEvent {

    String query;

    public QueryEvent(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}

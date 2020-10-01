package com.e.msappsreview.api.response

import com.e.msappsreview.models.MovieModel
import com.google.gson.annotations.Expose

class ListResponse(
    @Expose
    var movies: List<ItemResponse>
) {
    fun movieItemsToList(): List<MovieModel> {
        val movieList: ArrayList<MovieModel> = ArrayList()
        for (movieItem in movies) {
            movieList.add(movieItem.toMovie())
        }
        return movieList
    }
}
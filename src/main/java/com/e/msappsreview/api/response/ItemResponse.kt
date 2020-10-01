package com.e.msappsreview.api.response

import com.e.msappsreview.models.MovieModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemResponse(
    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("image")
    @Expose
    var image: String? = null,

    @SerializedName("rating")
    @Expose
    var rating: Double? = null,

    @SerializedName("releaseYear")
    @Expose
    var releaseYear: Int? = null,

    @SerializedName("genre")
    @Expose
    var genre: Array<String>? = null
) {
    fun toMovie(): MovieModel {
        return MovieModel(
            title = title,
            image = image,
            rating = rating,
            releaseYear = releaseYear,
            genre = genre
        )
    }

}
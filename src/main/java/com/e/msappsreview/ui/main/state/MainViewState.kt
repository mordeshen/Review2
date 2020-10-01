package com.e.msappsreview.ui.main.state

import com.e.msappsreview.models.MovieModel

class MainViewState(

    var listFields: ListFields = ListFields(),
    var itemFields: ItemFields = ItemFields()

) {
    data class ListFields(
        var movies: List<MovieModel>? = null
    )

    data class ItemFields(
        var movie: MovieModel? = null
    )
}
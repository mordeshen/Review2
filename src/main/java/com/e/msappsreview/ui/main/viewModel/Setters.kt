package com.e.msappsreview.ui.main.viewModel

import com.e.msappsreview.models.MovieModel

fun MainViewModel.setMovieList(movieList: List<MovieModel>) {
    val update = getCurrentViewStateOrNew()
    update.listFields.movies = movieList
    setViewState(update)
}

fun MainViewModel.setSearchByNameEvent

//fun MainViewModel.setQuery(query:String){
//    val update = getCurrentViewStateOrNew()
//    update
//}
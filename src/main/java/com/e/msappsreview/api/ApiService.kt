package com.e.msappsreview.api

import androidx.lifecycle.LiveData
import com.e.msappsreview.api.response.ListResponse
import com.e.msappsreview.util.GenericApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movies.json")
    fun getMovies(): LiveData<GenericApiResponse<ListResponse>>
}
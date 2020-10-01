package com.e.msappsreview.ui.main.viewModel

import androidx.lifecycle.LiveData
import com.bumptech.glide.RequestManager
import com.e.msappsreview.repository.MainRepository
import com.e.msappsreview.ui.BaseViewModel
import com.e.msappsreview.ui.DataState
import com.e.msappsreview.ui.main.state.MainStateEvent
import com.e.msappsreview.ui.main.state.MainViewState
import com.e.msappsreview.util.AbsentLiveData
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

class MainViewModel
@Inject
constructor(
//    private val sessionManager: SessionManager,
    private val mainRepository: MainRepository,
//    private val sharedPreferences: SharedPreferences,
    private val requestManager: RequestManager
) : BaseViewModel<MainStateEvent, MainViewState>() {
    @OptIn(InternalCoroutinesApi::class)
    override fun handleStateEvent(stateEvent: MainStateEvent): LiveData<DataState<MainViewState>> {
        return when (stateEvent) {
            is MainStateEvent.GetMainMoviesEvent -> {
                mainRepository.getMovies()
            }
            is MainStateEvent.GetMovieByName -> {
                mainRepository.apiMainService
            }
            is MainStateEvent.None -> {
                AbsentLiveData.create()
            }
        }
    }

    override fun initNewViewState(): MainViewState {
        return MainViewState()
    }

    fun cancelActiveJobs() {
        mainRepository.cancelActiveJobs()
        handlePendingData()
    }

    private fun handlePendingData() {
        setStateEvent(MainStateEvent.None())
    }

    override fun onCleared() {
        super.onCleared()
        cancelActiveJobs()
    }

}
package com.e.msappsreview.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.RequestManager
import com.e.msappsreview.R
import com.e.msappsreview.ui.DataStateChangeListener
import com.e.msappsreview.ui.main.viewModel.MainViewModel
import com.e.msappsreview.viewmodelProvider.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseMainFragment : DaggerFragment() {

    val TAG: String = "AppDebug"

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var stateChangeListener: DataStateChangeListener

    lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBarWithNavController(R.id.ListFragment, activity as AppCompatActivity)

        viewModel = activity?.run {
            ViewModelProvider(this, providerFactory).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        cancelActiveJobs()
    }

    fun cancelActiveJobs() {
        viewModel.cancelActiveJobs()
    }

    fun setupActionBarWithNavController(fragmentId: Int, activity: AppCompatActivity) {
        val appBarConfiguration = AppBarConfiguration(setOf(fragmentId))
        NavigationUI.setupActionBarWithNavController(
            activity,
            findNavController(),
            appBarConfiguration
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            stateChangeListener = context as DataStateChangeListener
        } catch (e: ClassCastException) {
            Log.e(TAG, "$context must implement DataStateChangeListener")
        }
    }
}
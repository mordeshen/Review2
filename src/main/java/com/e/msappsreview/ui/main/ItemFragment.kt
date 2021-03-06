package com.e.msappsreview.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.e.msappsreview.R
import com.e.msappsreview.models.MovieModel
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.list_item_layout.item_img

class ItemFragment : BaseMainFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        subscribeObservers()

        view.findViewById<Button>(R.id.item_to_list_back_button).setOnClickListener {
            findNavController().navigate(R.id.action_ItemFragment_to_ListFragment)
        }
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            stateChangeListener.onDataStateChange(dataState)
        })

        viewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            viewState.itemFields.movie?.let {
                setMovieProperties(it)
            }
        })
    }

    private fun setMovieProperties(model: MovieModel) {
        requestManager.load(model.image)
            .transition(withCrossFade())
            .into(item_img)
        item_title.text = model.title.toString()
        item_genre.text = model.genre.toString()
        item_year.text = model.releaseYear.toString()
        item_raating.text = model.rating.toString()

    }
}
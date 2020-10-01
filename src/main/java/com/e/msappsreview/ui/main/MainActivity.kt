package com.e.msappsreview.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.e.msappsreview.R
import com.e.msappsreview.ui.BaseActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val navController = findNavController(R.id.nav_host_fragment_container)
        Navigation.setViewNavController(fab, navController)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            // TODO: 06/09/2020 check if exist in db
            navToScanQr(view)
        }

    }

    private fun navToScanQr(view: View?) {
        if (view!!.findNavController().currentDestination!!.equals(R.id.ListFragment)) {
            view.findNavController().navigate(R.id.action_ListFragment_to_scanQrFragment)
        }
    }

    private fun showSnackBar(view: View) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }


    override fun expandAppBar() {
        TODO("Not yet implemented")
    }

    override fun displayProgressBar(boolean: Boolean) {
        TODO("Not yet implemented")
    }

}
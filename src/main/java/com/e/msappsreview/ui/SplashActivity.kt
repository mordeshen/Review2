package com.e.msappsreview.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.msappsreview.R
import com.e.msappsreview.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

//    1. get the information from api
//    check if (the db is up to date){
//    get from db the data and nav to main
//    } else {
//    get the data from the api
//    }


    fun navToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
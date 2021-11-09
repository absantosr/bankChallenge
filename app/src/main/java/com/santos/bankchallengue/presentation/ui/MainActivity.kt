package com.santos.bankchallengue.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santos.bankchallengue.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.flContent, HostFragment())
            .commit()
    }
}
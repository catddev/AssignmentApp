package com.junodev.assignmentapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junodev.assignmentapp.R
import com.junodev.assignmentapp.ui.tiles.view.TilesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TilesFragment.newInstance())
                .commit()
        }
    }
}
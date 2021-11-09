package com.elkhami.foodcategories.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elkhami.foodcategories.R
import com.elkhami.foodcategories.extensions.FragmentExtensions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
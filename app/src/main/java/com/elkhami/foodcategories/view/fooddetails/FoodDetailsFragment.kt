package com.elkhami.foodcategories.view.fooddetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elkhami.foodcategories.R

class FoodDetailsFragment : Fragment() {

    private lateinit var viewModel: FoodDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_details, container, false)
    }

}
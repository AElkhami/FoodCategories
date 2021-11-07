package com.elkhami.foodcategories.view.categorieslist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elkhami.foodcategories.R

class CategoriesListFragment : Fragment() {

    private lateinit var viewModel: CategoriesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories_list, container, false)
    }


}
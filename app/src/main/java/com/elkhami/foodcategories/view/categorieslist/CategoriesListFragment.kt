package com.elkhami.foodcategories.view.categorieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.elkhami.foodcategories.R
import com.elkhami.foodcategories.databinding.FragmentCategoriesListBinding
import com.elkhami.foodcategories.view.utils.ViewOperations.manageLoadingState
import com.elkhami.foodcategories.view.utils.ViewOperations.onErrorReceived
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoriesListFragment : Fragment() {

    private val viewModel: CategoriesListViewModel by viewModels()

    private var _binding: FragmentCategoriesListBinding? = null
    private val binding get() = _binding!!

    private val adapter = CategoriesListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_categories_list,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()

        collectCategoriesList()
    }

    private fun collectCategoriesList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collectLatest { uiState ->

                    uiState.data?.let { foodCategories ->
                        adapter.submitList(foodCategories)
                    }

                    manageLoadingState(binding.loadingProgress, uiState.isLoading)

                    onErrorReceived(this@CategoriesListFragment, uiState.errorType, uiState.message)
                }
            }
        }
    }

    private fun setUpAdapter() {
        binding.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
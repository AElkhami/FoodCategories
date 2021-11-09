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
import com.elkhami.foodcategories.data.model.Product
import com.elkhami.foodcategories.data.other.ErrorType
import com.elkhami.foodcategories.databinding.FragmentCategoriesListBinding
import com.elkhami.foodcategories.extensions.FragmentExtensions.showSnackBar
import com.elkhami.foodcategories.extensions.FragmentExtensions.startLoading
import com.elkhami.foodcategories.extensions.FragmentExtensions.stopLoading
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoriesListFragment : Fragment() {

    private val viewModel: CategoriesListViewModel by viewModels()
    private lateinit var binding: FragmentCategoriesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_categories_list,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collectLatest { uiState ->

                    setUpAdapter(uiState.foodCategories)

                    manageLoadingState(uiState.isLoading)

                    onErrorReceived(uiState.errorType, uiState.message)
                }
            }
        }
    }

    private fun setUpAdapter(foodCategories: List<Product>) {
        val adapter = CategoriesListAdapter()
        adapter.submitList(foodCategories)
        binding.adapter = adapter
    }

    private fun manageLoadingState(isLoading: Boolean) {
        if (isLoading) {
            startLoading(binding.loadingProgress)
        } else {
            stopLoading(binding.loadingProgress)
        }
    }

    private fun onErrorReceived(errorType: ErrorType?, message: String?) {
        when (errorType) {
            ErrorType.UnknownError -> {
                showSnackBar(getString(R.string.unknown_error_message))
            }
            ErrorType.NetworkError -> {
                showSnackBar(getString(R.string.network_error_message))
            }
            ErrorType.ResponseError -> {
                message?.let {
                    showSnackBar(it)
                }
            }
        }
    }
}
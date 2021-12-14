package com.elkhami.foodcategories.view.fooddetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.elkhami.foodcategories.databinding.FragmentFoodDetailsBinding
import com.elkhami.foodcategories.extensions.GlideExtensions.loadImage

class FoodDetailsFragment : Fragment() {

    private var _binding: FragmentFoodDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: FoodDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFoodDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayProductDetails()
    }

    private fun displayProductDetails() {
        val foodDetails = args.foodDetails
        foodDetails.url?.let {
            binding.productImageView.loadImage(it)
        }
        foodDetails.name?.let {
            binding.productNameTextView.text = it
        }
        foodDetails.salePrice?.let { salePrice ->
            binding.productPriceTextView.text = salePrice.amount
            binding.productPriceCurrencyText.text = salePrice.currency
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
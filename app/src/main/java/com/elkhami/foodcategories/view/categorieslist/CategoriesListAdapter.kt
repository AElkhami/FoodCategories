package com.elkhami.foodcategories.view.categorieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.elkhami.foodcategories.data.model.Product
import com.elkhami.foodcategories.databinding.CategoryItemBinding
import com.elkhami.foodcategories.databinding.FoodItemBinding
import com.elkhami.foodcategories.extensions.GlideExtensions.loadImage

/**
 * Created by A.Elkhami on 06,November,2021
 */

private const val HEADER = 0
private const val BODY = 1

class CategoriesListAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differ = AsyncListDiffer(this, DiffUtilCallback())

    fun submitList(categoryList: List<Product>) {
        differ.submitList(categoryList)
    }

    class HeaderViewHolder constructor(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindHeader(categoryName: String) {
            binding.categoryName = categoryName
        }

        companion object {
            fun from(parent: ViewGroup): HeaderViewHolder {
                val binding = CategoryItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return HeaderViewHolder(binding)
            }
        }
    }

    class BodyViewHolder constructor(private val binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindBody(product: Product) {
            binding.product = product
        }

        companion object {

            @JvmStatic
            @BindingAdapter("imageUrl")
            fun setImageUrl(imgView: ImageView, url: String){
                imgView.loadImage(url)
            }

            fun from(parent: ViewGroup): BodyViewHolder {
                val binding = FoodItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return BodyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER -> {
                HeaderViewHolder.from(parent)
            }
            BODY -> {
                BodyViewHolder.from(parent)
            }
            else -> BodyViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val categoryItem = differ.currentList[position]

        when (getItemViewType(position)) {
            HEADER -> {
                (holder as HeaderViewHolder).bindHeader(categoryItem.name!!)
            }
            BODY -> {
                (holder as BodyViewHolder).bindBody(categoryItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            differ.currentList[position].id.equals(null) -> {
                HEADER
            }
            else -> {
                BODY
            }
        }
    }
}

class DiffUtilCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}
package com.elkhami.foodcategories.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.elkhami.foodcategories.R
import com.elkhami.foodcategories.utils.Constants.ROUNDING_RADIUS

/**
 * Created by A.Elkhami on 08,November,2021
 */
object GlideExtensions {

    fun ImageView.loadImage(url: String) {
        Glide
            .with(context)
            .load(url)
            .placeholder(R.drawable.ic_no_image_found)
            .transform(CenterCrop(), RoundedCorners(ROUNDING_RADIUS))
            .into(this)
    }
}
package com.example.room

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class ImageSlideFragment(val image : Int) : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        img_slide_image.setImageResource(image)
    }
}
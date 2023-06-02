package com.example.roomins

import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class IdLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_login)

        val imageView = findViewById<ImageView>(R.id.arrow_matrix)
        val originalBitmap = (imageView.drawable as BitmapDrawable).bitmap
        val flippedBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.width, originalBitmap.height, Matrix().apply { postScale(-1f, 1f) }, true)
        imageView.setImageBitmap(flippedBitmap)
    }
}

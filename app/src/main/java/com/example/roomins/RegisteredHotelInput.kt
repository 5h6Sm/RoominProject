package com.example.roomins

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.roomins.RegisteredHotelMap

class RegisteredHotelInput : AppCompatActivity() {
    private lateinit var searchBox: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registered_hotel_input)

        searchBox = findViewById(R.id.map_input)

        val searchButton: Button = findViewById(R.id.button2)
        searchButton.setOnClickListener {
            val searchText: String = searchBox.text.toString()
            val geocoder = Geocoder(baseContext)
            var addresses: List<Address>? = null
            try {
                addresses = geocoder.getFromLocationName(searchText, 1)
                if (addresses != null && addresses.isNotEmpty()) {
                    val address = addresses[0]
                    val latitude = address.latitude
                    val longitude = address.longitude
                    val locationName = address.getAddressLine(0)
                    Log.d("mytag", "hi")

                    val intent = Intent(this@RegisteredHotelInput, RegisteredHotelMap::class.java)
                    intent.putExtra("latitude", latitude)
                    intent.putExtra("longitude", longitude)
                    intent.putExtra("locationName", locationName)
                    startActivity(intent)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

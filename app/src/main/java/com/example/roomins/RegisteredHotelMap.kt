package com.example.roomins

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class RegisteredHotelMap : AppCompatActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    private var latitude: Double? = null
    private var longitude: Double? = null
    private var locationName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registered_hotel_map)

        var nobutton = findViewById<Button>(R.id.nobutton)
        var yesbutton = findViewById<Button>(R.id.yesbutton)

        nobutton.setOnClickListener{
            val intent = Intent(this@RegisteredHotelMap, RegisteredHotelInput::class.java)
            startActivity(intent)
        }
        yesbutton.setOnClickListener{
            val intent = Intent(this@RegisteredHotelMap, RegisteredHotelFinal::class.java)
            startActivity(intent)
        }

        latitude = intent.getDoubleExtra("latitude", 0.0)
        longitude = intent.getDoubleExtra("longitude", 0.0)
        locationName = intent.getStringExtra("locationName")


        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        val areaNameTextView = findViewById<TextView>(R.id.areaname)
        areaNameTextView.text = locationName
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latLng = LatLng(latitude ?: 0.0, longitude ?: 0.0)
        val markerOptions = MarkerOptions().position(latLng).title(locationName)
        mMap?.addMarker(markerOptions)
        mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
    }
}

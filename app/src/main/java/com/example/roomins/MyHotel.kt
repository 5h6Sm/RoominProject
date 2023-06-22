package com.example.roomins

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.roomins.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Data {
    @FormUrlEncoded
    @POST("updateData")
    fun updateData(
        @Field("HotelName") hotelname: String,
        @Field("address") address: String,
        @Field("LengthOfStay") period: String,
        @Field("CheckInStatus") checkin: String,
        @Field("CheckOutStatus") checkout: String,
        @Field("id") id: String
    ): Call<Void>
}

class MyHotel : AppCompatActivity() {
    private var id: String = ""
    private var hotelname: String = ""
    private var address: String = ""
    private var period: String = ""
    private var checkin: String = ""
    private var checkout: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_hotel)

        val hotelnameEditText = findViewById<EditText>(R.id.hotel_name)
        val addressEditText = findViewById<EditText>(R.id.hotel_address)
        val periodEditText = findViewById<EditText>(R.id.period)
        val checkinEditText = findViewById<EditText>(R.id.checkin)
        val checkoutEditText = findViewById<EditText>(R.id.checkout)

        val idEditText = findViewById<EditText>(R.id.id)
        val button = findViewById<Button>(R.id.hotel_btn)

        button.setOnClickListener {
            val hotelname = hotelnameEditText.text.toString()
            val address = addressEditText.text.toString()
            val period = periodEditText.text.toString()
            val checkin = checkinEditText.text.toString()
            val checkout = checkoutEditText.text.toString()
            val id = idEditText.text.toString()

            updateData( hotelname, address, period, checkin, checkout, id)



            // Continue with other operations
        }
    }

    private fun updateData( hotelname: String, address: String, period: String, checkin: String, checkout: String, id: String) {
        // Update the data in the fields
        this.id = id
        this.hotelname = hotelname
        this.address = address
        this.period = period
        this.checkin = checkin
        this.checkout = checkout

        // Perform the necessary operations to update the userTable with the updated data
        // Similar to the storeData() method, you can use Retrofit or any other mechanism
        // to send an API request and update the userTable with the provided data.
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000") // Update with your API endpoint
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(Data::class.java)
        val call = apiService.updateData(hotelname, address, period, checkin, checkout, id)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // Data updated successfully
                    Log.d("mytag", "Data updated successfully")
                } else {
                    // Request failed
                    Log.d("mytag", "Update request failed")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Handle failure
                Log.d("mytag", "Update request failed")
            }
        })
    }
}

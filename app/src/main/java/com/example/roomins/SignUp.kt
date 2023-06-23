package com.example.roomins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("/insertUser")
    fun insertUser(
        @Field("name") name: String,
        @Field("id") id: String,
        @Field("password") password: String,
        @Field("phone") phone: String
    ): Call<Void>
}

class SignUp : AppCompatActivity() {
    data class YourDataClass(
        val name: String,
        val id: String,
        val password: String,
        val phone: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.37:3000") // Replace with your Node.js server URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Log.d("mytag", "ok")

        val service = retrofit.create(ApiService::class.java)

        val clearButton = findViewById<Button>(R.id.clear)
        clearButton.setOnClickListener {
            val name = input_name.text.toString()
            val id = input_id.text.toString()
            val password = password.text.toString()
            val phone = phone_num.text.toString()

            val dataToSend = YourDataClass(name, id, password, phone)
            Log.d("mytag", "Data to send: $dataToSend")

            val call: Call<Void> = service.insertUser(
                dataToSend.name,
                dataToSend.id,
                dataToSend.password,
                dataToSend.phone
            )

            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        // Handle successful response
                        Log.d("mytag", "Connection to server successful")
                        Log.d("mytag", "Hello!")
                    } else {
                        Log.d("mytag", "Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("mytag", "Connection failed: ${t.message}")
                }
            })
            val intent = Intent(this@SignUp, HomeActivity::class.java)
            startActivity(intent)

        }
    }

}
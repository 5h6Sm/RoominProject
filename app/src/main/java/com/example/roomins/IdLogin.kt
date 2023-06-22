package com.example.roomins

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.example.roomins.HomeActivity


interface Authentication {
    @FormUrlEncoded
    @POST("authenticate")
    fun authenticate(
        @Field("id") id: String,
        @Field("password") password: String
    ): Call<Void>
}


class IdLogin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_login)

        val idEditText = findViewById<EditText>(R.id.id)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val id = idEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Perform the necessary operations to check the ID and password against the database
            // For example, you can use Retrofit or any other mechanism to send an API request
            // to your Node.js server and validate the credentials.

            // Example usage of Retrofit:
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.37:3000/") // Update with your API endpoint
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(Authentication::class.java)
            val call = apiService.authenticate(id, password)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        // Authentication successful, move to the next screen
                        val intent = Intent(this@IdLogin, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        if (response.code() == 401) {
                            // Authentication failed
                            Log.d("mytag", "Invalid ID or password")
                        } else {
                            // Handle other error cases
                            Log.d("mytag", "Authentication request failed")
                        }
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    // Handle failure
                    Log.d("mytag", "Authentication request failed")
                }
            })

        }
    }
}
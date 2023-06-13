package com.example.roomins

import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import com.example.roomins.databinding.ActivityInternetCallBinding

class InternetCall : AppCompatActivity() {
    var dataArr = arrayOf("방 비밀번호 요청", "호텔 비밀번호 요청")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityInternetCallBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val comboBox: Spinner = binding.comboBox
        val result: TextView = binding.result
        var linearLayout: LinearLayout = binding.visibleLayout
        linearLayout.visibility = View.GONE

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dataArr)
        comboBox.adapter = adapter
        comboBox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                result.text = "3,000원"

                if(position == 0){
                    linearLayout.visibility = View.GONE
                }else{
                    linearLayout.visibility = View.VISIBLE
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }
}



class CustomArrayAdapter(context: Context, resource: Int, objects: Array<String>) :
    ArrayAdapter<String>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent) as TextView
        view.typeface = Typeface.createFromAsset(context.assets, "font/gmarketsansmedium.otf") // 원하는 폰트 설정
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent) as TextView
        view.typeface = Typeface.createFromAsset(context.assets, "font/gmarketsansmedium.otf") // 원하는 폰트 설정
        return view
    }
}
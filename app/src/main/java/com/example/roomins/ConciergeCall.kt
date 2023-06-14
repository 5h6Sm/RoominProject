package com.example.roomins

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text

class CustomAdapter(context: Context, resource: Int, objects: Array<String>, private val fontPath: String) :
    ArrayAdapter<String>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        val typeface = Typeface.createFromAsset(context.assets, fontPath)
        textView.typeface = typeface
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        val typeface = Typeface.createFromAsset(context.assets, fontPath)
        textView.typeface = typeface
        return view
    }
}

class ConciergeCall : AppCompatActivity() {
    var dataArr = arrayOf("방키, 열쇠 분실", "소음공해 신고", "방 전등 고장", "신문, 잡지 제공", "기타")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concierge_call)

        val button_select = findViewById<AppCompatButton>(R.id.button_select)

        button_select.setOnClickListener {
            val serviceintent: ImageButton = findViewById(R.id.service_intent)
            serviceintent.setOnClickListener {
                val intent = Intent(this, ServiceFragment::class.java)
                startActivity(intent)
            }

            // bottomSheetDialog 객체 생성
            val bottomSheetDialog = BottomSheetDialog(this)
            // layout_bottom_sheet_concierge 레이아웃을 뷰로 생성
            val bottomSheetView = layoutInflater.inflate(R.layout.layout_bottom_sheet_concierge, null)
            // bottomSheetDialog 뷰 생성
            bottomSheetDialog.setContentView(bottomSheetView)
            // bottomSheetDialog 호출
            bottomSheetDialog.show()

            val intentbtn: AppCompatButton = bottomSheetView.findViewById(R.id.button_select2)

            val comboBox = bottomSheetView.findViewById<Spinner>(R.id.comboBox)
            val result1 = findViewById<TextView>(R.id.show1)

            val adapter = CustomAdapter(this, android.R.layout.simple_spinner_dropdown_item, dataArr, "fonts/gmarketsansmedium.otf")
            comboBox.adapter = adapter
            comboBox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    result1.text = dataArr[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Do nothing
                }
            }

            intentbtn.setOnClickListener {
                val input2 = bottomSheetView.findViewById<EditText>(R.id.textinput2).text.toString()
                val result2 = findViewById<TextView>(R.id.show2)

                result2.text = input2
                bottomSheetDialog.dismiss() // 다이얼로그 닫기
            }
        }
    }
}

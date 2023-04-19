package com.example.roomins

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TimePicker
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.bottomsheet.BottomSheetDialog

class ChoiceCall : AppCompatActivity() {
    private lateinit var timePicker: TimePicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_call)
        val button_select = findViewById<AppCompatButton>(R.id.button_select)

        button_select.setOnClickListener {
            // bottomSheetDialog 객체 생성
            val bottomSheetDialog = BottomSheetDialog(this)
            // layout_bottom_sheet 레이아웃을 뷰로 생성
            val bottomSheetView = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
            // bottomSheetDialog 뷰 생성
            bottomSheetDialog.setContentView(bottomSheetView)
            // bottomSheetDialog 호출
            bottomSheetDialog.show()
            timePicker = bottomSheetView.findViewById<TimePicker>(R.id.timePicker)

            // 체크박스 선언 및 초기화
            val checkBox1 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton1)
            val checkBox2 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton2)
            val checkBox3 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton3)

            // 체크박스 클릭 시 이벤트 처리
            checkBox1.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox1.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox1.setBackgroundColor(Color.parseColor("#DF8494"))
                } else {
                    checkBox1.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox1.setBackgroundColor(Color.parseColor("#F4F4F4"))
                }
            }
            checkBox2.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox2.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox2.setBackgroundColor(Color.parseColor("#DF8494"))
                } else {
                    checkBox2.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox2.setBackgroundColor(Color.parseColor("#F4F4F4"))
                }
            }
            checkBox3.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox3.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox3.setBackgroundColor(Color.parseColor("#DF8494"))
                } else {
                    checkBox3.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox3.setBackgroundColor(Color.parseColor("#F4F4F4"))
                }
            }

            // 다중 선택을 가능하도록 체크박스의 속성 변경
            checkBox1.isClickable = true
            checkBox1.isFocusable = true
            checkBox1.isPressed = false

            checkBox2.isClickable = true
            checkBox2.isFocusable = true
            checkBox2.isPressed = false

            checkBox3.isClickable = true
            checkBox3.isFocusable = true
            checkBox3.isPressed = false
            checkBox3.isDuplicateParentStateEnabled = false

        }
    }
}
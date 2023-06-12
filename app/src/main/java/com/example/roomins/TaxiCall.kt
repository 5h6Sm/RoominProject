package com.example.roomins

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*

class TaxiCall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxi_call)

        val button_select = findViewById<AppCompatButton>(R.id.button_select)

        button_select.setOnClickListener {
            var serviceintent:ImageButton = findViewById(R.id.service_intent)
            serviceintent.setOnClickListener{
                val intent = Intent(this, ServiceFragment::class.java)
                startActivity(intent)
            }


        // bottomSheetDialog 객체 생성
        val bottomSheetDialog = BottomSheetDialog(this)
        // layout_bottom_sheet 레이아웃을 뷰로 생성
        val bottomSheetView = layoutInflater.inflate(R.layout.layout_bottom_sheet4, null)
        // bottomSheetDialog 뷰 생성
        bottomSheetDialog.setContentView(bottomSheetView)
        // bottomSheetDialog 호출
        bottomSheetDialog.show()

            val intentbtn : AppCompatButton = bottomSheetView.findViewById(R.id.button_select2)
            val day : NumberPicker = bottomSheetView.findViewById(R.id.day_datepicker)
            val hour : NumberPicker = bottomSheetView.findViewById(R.id.hour_datepicker)
            val minute : NumberPicker = bottomSheetView.findViewById(R.id.minute_datepicker)

            //  순환 안되게 막기
            day.wrapSelectorWheel = false
            hour.wrapSelectorWheel = false
            minute.wrapSelectorWheel = false

            //  editText 설정 해제
            day.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            hour.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            minute.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS

            val calendar = Calendar.getInstance()
            var today = calendar.get(Calendar.DAY_OF_WEEK)
            var days = calendar.get(Calendar.DAY_OF_MONTH) + 1
            var month = calendar.get(Calendar.MONTH) + 1

            //  최소값 설정
            day.minValue = 1
            hour.minValue = 1
            minute.minValue = 1

            //  최대값 설정
            day.maxValue = 31
            hour.maxValue = 24
            minute.maxValue = 59

            //보여질 값 설정
            val dayDisplayedValues = mutableListOf<String>()
            for (i in 0 .. 30){
                if(days == 31) {
                    days = 1;
                    month+=1;
                }
                if(today > 6) today = 0;
                var dayOfWeek = when(today) {
                    0 -> "일요일"
                    1 -> "월요일"
                    2 -> "화요일"
                    3 -> "수요일"
                    4 -> "목요일"
                    5-> "금요일"
                    6 -> "토요일"
                    else -> ""
                }

                dayOfWeek = dayOfWeek.substring(0,1)
                dayDisplayedValues.add("$month/$days($dayOfWeek)")
                days++;
                today++;
            }
            day.setDisplayedValues(dayDisplayedValues.toTypedArray())
            hour.setDisplayedValues(arrayOf("09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23","24", "01", "02", "03", "04", "05", "06", "07"))

            val minuteDisplayedValues = mutableListOf<String>()
            for (i in 1..59) {
                minuteDisplayedValues.add(i.toString())
            }
            minute.setDisplayedValues(minuteDisplayedValues.toTypedArray())

            val text_edit_noice = bottomSheetView.findViewById<TextView>(R.id.text_edit_noice);

            val content = text_edit_noice.text.toString();
            val spannableString = SpannableString(content);

            val world = "위와 같이"
            val start = content.indexOf(world)
            val end = start + world.length;
            spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#DF8494")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            text_edit_noice.setText(spannableString);


            intentbtn.setOnClickListener {
                val selectedDay = day.displayedValues[day.value - 1]
                val selectedHour = hour.displayedValues[hour.value - 1]
                var selectedMinute = minute.displayedValues[minute.value - 1]

                val selectedDay1 = selectedDay.split("/")
                var ampm = "오전"
                if(selectedHour.toInt() >= 13){
                    ampm = "오후"
                }
                if(selectedMinute.toInt() < 10){
                    selectedMinute = "0$selectedMinute"
                }
                val formattedText = "  ${selectedDay1.get(0)}월 ${selectedDay1.get(1).split("(").get(0)}일  $ampm ${selectedHour.toInt()}:$selectedMinute"
                val textView = findViewById<TextView>(R.id.choice_text)
                textView.text = formattedText

                val Calling = findViewById<TextView>(R.id.roomcalling)
                val AddText = findViewById<TextView>(R.id.add)

                AddText.text = ""
                val input1 = bottomSheetView.findViewById<EditText>(R.id.textinput1).text.toString()
                val input2 = bottomSheetView.findViewById<EditText>(R.id.textinput2).text.toString()

                val show1 = findViewById<TextView>(R.id.show1)
                show1.text = input1

                val show2 = findViewById<TextView>(R.id.show2)
                show2.text = input2
                bottomSheetDialog.dismiss() // 다이어로그 닫기
            }
        }
    }
}
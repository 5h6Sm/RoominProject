package com.example.roomins

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.selects.select
import java.util.*

class ChoiceMinibar : AppCompatActivity() {
    private lateinit var timePicker: TimePicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_call)
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
            val bottomSheetView = layoutInflater.inflate(R.layout.layout_bottom_sheet2, null)
            // bottomSheetDialog 뷰 생성
            bottomSheetDialog.setContentView(bottomSheetView)
            // bottomSheetDialog 호출
            bottomSheetDialog.show()

            val intentbtn : AppCompatButton = bottomSheetView.findViewById(R.id.buttongo2)
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

            // 체크박스 선언 및 초기화
            val selectedTextView = bottomSheetView.findViewById<TextView>(R.id.selectedTextView)
            val checkBox1 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton1)
            val checkBox2 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton2)
            val checkBox3 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton3)
            val checkBox4 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton7)
            val checkBox5 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton4)
            val checkBox6 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton5)
            val checkBox7 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton6)

            fun appendSelectedText(selectedText: String) {
                val currentText = selectedTextView.text.toString()
                val newText = if (currentText.isEmpty()) {
                    selectedText
                } else {
                    "$currentText\n$selectedText"
                }
                selectedTextView.text = newText
            }

            // 체크박스 클릭 시 이벤트 처리
            checkBox1.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox1.setBackgroundResource(R.drawable.toggle_button_clicked)
                    checkBox1.setTextColor(Color.parseColor("#FBFBFB"))
                    val selectedText = checkBox1.text.toString()
                    appendSelectedText(selectedText)
                } else {
                    checkBox1.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox1.setBackgroundResource(R.drawable.toggle_button_background)
                }
            }

            checkBox2.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox2.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox2.setBackgroundResource(R.drawable.toggle_button_clicked)
                    val selectedText = checkBox2.text.toString()
                    appendSelectedText(selectedText)
                } else {
                    checkBox2.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox2.setBackgroundResource(R.drawable.toggle_button_background)
                }
            }

            checkBox3.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox3.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox3.setBackgroundResource(R.drawable.toggle_button_clicked)
                    val selectedText = checkBox3.text.toString()
                    appendSelectedText(selectedText)
                } else {
                    checkBox3.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox3.setBackgroundResource(R.drawable.toggle_button_background)
                }
            }
            checkBox4.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox4.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox4.setBackgroundResource(R.drawable.toggle_button_clicked)
                    val selectedText = checkBox4.text.toString()
                    appendSelectedText(selectedText)
                } else {
                    checkBox4.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox4.setBackgroundResource(R.drawable.toggle_button_background)
                }
            }
            checkBox5.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox5.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox5.setBackgroundResource(R.drawable.toggle_button_clicked)
                    val selectedText = checkBox5.text.toString()
                    appendSelectedText(selectedText)
                } else {
                    checkBox5.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox5.setBackgroundResource(R.drawable.toggle_button_background)
                }
            }
            checkBox6.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox6.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox6.setBackgroundResource(R.drawable.toggle_button_clicked)
                    val selectedText = checkBox6.text.toString()
                    appendSelectedText(selectedText)
                } else {
                    checkBox6.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox6.setBackgroundResource(R.drawable.toggle_button_background)
                }
            }
            checkBox7.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox7.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox7.setBackgroundResource(R.drawable.toggle_button_clicked)
                    val selectedText = checkBox7.text.toString()
                    appendSelectedText(selectedText)
                } else {
                    checkBox7.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox7.setBackgroundResource(R.drawable.toggle_button_background)
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
                // 체크된 체크박스의 텍스트 추출
                val selectedCheckBoxTexts = mutableListOf<String>()
                if (checkBox1.isChecked) {
                    selectedCheckBoxTexts.add(checkBox1.text.toString())
                }
                if (checkBox2.isChecked) {
                    selectedCheckBoxTexts.add(checkBox2.text.toString())
                }
                if (checkBox3.isChecked) {
                    selectedCheckBoxTexts.add(checkBox3.text.toString())
                }

                val Calling = findViewById<TextView>(R.id.roomcalling)
                val existingText = Calling.text.toString()
                val newText = if (existingText.isNotEmpty()) {
                    "${selectedCheckBoxTexts.joinToString(", ")}"
                } else {
                    "${selectedCheckBoxTexts.joinToString(", ")}"
                }
                Calling.text = newText
                val userinput_edittext_boardwrite = bottomSheetView.findViewById<EditText>(R.id.textinput);
                val wordcount_textview_boardwrite = bottomSheetView.findViewById<TextView>(R.id.textView)
                userinput_edittext_boardwrite.addTextChangedListener(object: TextWatcher {

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        wordcount_textview_boardwrite.text = "0 / 50"
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        var userinput = userinput_edittext_boardwrite.text.toString()
                        wordcount_textview_boardwrite.text = userinput.length.toString() + " / 50"
                    }

                    override fun afterTextChanged(s: Editable?) {
                        var userinput = userinput_edittext_boardwrite.text.toString()
                        wordcount_textview_boardwrite.text = userinput.length.toString() + " / 50"
                    }

                })

                bottomSheetDialog.dismiss() // 다이어로그 닫기
            }
        }
    }
}
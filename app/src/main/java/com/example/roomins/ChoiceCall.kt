package com.example.roomins

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.set
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*
import kotlin.math.min

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
            val today = calendar.get(Calendar.DAY_OF_WEEK)
            val days = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH) + 1

            //  최소값 설정
            day.minValue = days
            hour.minValue = 1
            minute.minValue = 1

            //  최대값 설정
            day.maxValue = 31
            hour.maxValue = 23
            minute.maxValue = 59

            val dayOfWeek = when(today) {
                Calendar.SUNDAY -> "일요일"
                Calendar.MONDAY -> "월요일"
                Calendar.TUESDAY -> "화요일"
                Calendar.WEDNESDAY -> "수요일"
                Calendar.THURSDAY -> "목요일"
                Calendar.FRIDAY -> "금요일"
                Calendar.SATURDAY -> "토요일"
                else -> ""
            }

            //보여질 값 설정
            val dayDisplayedValues = mutableListOf<String>()
            dayDisplayedValues.add("오늘($dayOfWeek)")
            val tomorrowDayOfWeek = when((today+1)%7) {
                Calendar.SUNDAY -> "일요일"
                Calendar.MONDAY -> "월요일"
                Calendar.TUESDAY -> "화요일"
                Calendar.WEDNESDAY -> "수요일"
                Calendar.THURSDAY -> "목요일"
                Calendar.FRIDAY -> "금요일"
                Calendar.SATURDAY -> "토요일"
                else -> ""
            }
            dayDisplayedValues.add("$month/$days($tomorrowDayOfWeek)")
            day.setDisplayedValues(dayDisplayedValues.toTypedArray())

            hour.setDisplayedValues(arrayOf("09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"))

            val minuteDisplayedValues = mutableListOf<String>()
            for (i in 30..59) {
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

            // 체크박스 선언 및 초기화
            val checkBox1 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton1)
            val checkBox2 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton2)
            val checkBox3 = bottomSheetView.findViewById<CheckBox>(R.id.toggleButton3)

            // 체크박스 클릭 시 이벤트 처리
// 체크박스 클릭 시 이벤트 처리
            checkBox1.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox1.setBackgroundResource(R.drawable.toggle_button_clicked)
                    checkBox1.setTextColor(Color.parseColor("#FBFBFB"))
                } else {
                    checkBox1.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox1.setBackgroundResource(R.drawable.toggle_button_background)
                }
            }

            checkBox2.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox2.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox2.setBackgroundResource(R.drawable.toggle_button_clicked)
                } else {
                    checkBox2.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox2.setBackgroundResource(R.drawable.toggle_button_background)
                }
            }

            checkBox3.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    checkBox3.setTextColor(Color.parseColor("#FBFBFB"))
                    checkBox3.setBackgroundResource(R.drawable.toggle_button_clicked)
                } else {
                    checkBox3.setTextColor(Color.parseColor("#D1D1D1"))
                    checkBox3.setBackgroundResource(R.drawable.toggle_button_background)
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
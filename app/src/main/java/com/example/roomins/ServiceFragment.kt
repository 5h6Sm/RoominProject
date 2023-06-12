package com.example.roomins

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class ServiceFragment : Fragment(R.layout.fragment_service){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_service, container, false)

        val button = view.findViewById<LinearLayout>(R.id.morningcall)
        button.setOnClickListener {
            // 버튼 클릭 이벤트 처리
            val intent = Intent(activity, ChoiceCall::class.java)
            startActivity(intent)
        }


        return view
    }
}
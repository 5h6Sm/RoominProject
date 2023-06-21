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
        val bnt2 = view.findViewById<LinearLayout>(R.id.umbrella)
        bnt2.setOnClickListener {
            // 버튼 클릭 이벤트 처리
            val intent = Intent(activity, UmbrellaService::class.java)
            startActivity(intent)
        }
        val bnt3 = view.findViewById<LinearLayout>(R.id.cunsiuz)
        bnt3.setOnClickListener {
            // 버튼 클릭 이벤트 처리
//            val intent = Intent(activity, Cs::class.java)
//            startActivity(intent)
        }
        val bnt4 = view.findViewById<LinearLayout>(R.id.coffee)
        val bnt5 = view.findViewById<LinearLayout>(R.id.baby)
        val bnt6 = view.findViewById<LinearLayout>(R.id.te)
        val bnt7 = view.findViewById<LinearLayout>(R.id.sleep)
        val bnt8 = view.findViewById<LinearLayout>(R.id.lugize)
        val bnt9 = view.findViewById<LinearLayout>(R.id.internet)
        bnt9.setOnClickListener {
            // 버튼 클릭 이벤트 처리
            val intent = Intent(activity, InternetCall::class.java)
            startActivity(intent)
        }
        val bnt10 = view.findViewById<LinearLayout>(R.id.minibar)
        bnt10.setOnClickListener {
            // 버튼 클릭 이벤트 처리
            val intent = Intent(activity, ChoiceMinibar::class.java)
            startActivity(intent)
        }
        val bnt11 = view.findViewById<LinearLayout>(R.id.taxi)
        bnt11.setOnClickListener {
            // 버튼 클릭 이벤트 처리
            val intent = Intent(activity,TaxiCall::class.java)
            startActivity(intent)
        }
        val bnt12 = view.findViewById<LinearLayout>(R.id.water)
        val bnt13 = view.findViewById<LinearLayout>(R.id.savezim)
        val bnt14 = view.findViewById<LinearLayout>(R.id.day)
        val bnt15 = view.findViewById<LinearLayout>(R.id.wash)
        val bnt16 = view.findViewById<LinearLayout>(R.id.speaking)




        return view
    }
}
package com.example.roomins

import LoadingDialog
import android.content.Intent
import android.graphics.Color
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
        var selectedLinearLayout: LinearLayout? = null

        // LinearLayout 선택 시 호출되는 함수
        fun updateSelectedLinearLayout(linearLayout: LinearLayout) {
            selectedLinearLayout?.setBackgroundColor(Color.TRANSPARENT) // 이전에 선택한 LinearLayout의 배경색을 원래대로 되돌립니다.
            selectedLinearLayout = linearLayout
        }

        val button = view.findViewById<LinearLayout>(R.id.morningcall)

        button.setOnClickListener {
            val intent = Intent(requireActivity(), ChoiceCall::class.java)
            requireActivity().startActivity(intent)
        }

        val bnt2 = view.findViewById<LinearLayout>(R.id.umbrella)
        bnt2.setOnClickListener {
            val intent = Intent(requireActivity(), InternetCall::class.java)
            requireActivity().startActivity(intent)
        }

        val bnt3 = view.findViewById<LinearLayout>(R.id.cunsiuz)
        bnt3.setOnClickListener {
            val intent = Intent(requireActivity(), ConciergeCall::class.java)
            requireActivity().startActivity(intent)
        }
        val bnt4 = view.findViewById<LinearLayout>(R.id.coffee)
        val bnt5 = view.findViewById<LinearLayout>(R.id.baby)
        val bnt6 = view.findViewById<LinearLayout>(R.id.te)
        val bnt7 = view.findViewById<LinearLayout>(R.id.sleep)
        val bnt8 = view.findViewById<LinearLayout>(R.id.lugize)
        val bnt9 = view.findViewById<LinearLayout>(R.id.internet)
        bnt9.setOnClickListener {
            val intent = Intent(requireActivity(), ChoiceCall::class.java)
            requireActivity().startActivity(intent)
        }
        val bnt10 = view.findViewById<LinearLayout>(R.id.minibar)
        bnt10.setOnClickListener {
            val intent = Intent(requireActivity(), ChoiceCall::class.java)
            requireActivity().startActivity(intent)
        }
        val bnt11 = view.findViewById<LinearLayout>(R.id.taxi)
        bnt11.setOnClickListener {
            val intent = Intent(requireActivity(), TaxiCall::class.java)
            requireActivity().startActivity(intent)
        }
        val bnt12 = view.findViewById<LinearLayout>(R.id.water)
        val bnt13 = view.findViewById<LinearLayout>(R.id.savezim)
        val bnt14 = view.findViewById<LinearLayout>(R.id.day)
        val bnt15 = view.findViewById<LinearLayout>(R.id.wash)
        val bnt16 = view.findViewById<LinearLayout>(R.id.speaking)

        // 클릭 이벤트를 설정하는 함수를 정의합니다.
        fun setClickListeners() {
            bnt4.setOnClickListener {
                updateSelectedLinearLayout(bnt4)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            bnt5.setOnClickListener {
                updateSelectedLinearLayout(bnt5)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            bnt6.setOnClickListener {
                updateSelectedLinearLayout(bnt6)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            bnt7.setOnClickListener {
                updateSelectedLinearLayout(bnt7)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            bnt8.setOnClickListener {
                updateSelectedLinearLayout(bnt8)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            bnt12.setOnClickListener {
                updateSelectedLinearLayout(bnt12)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            bnt13.setOnClickListener {
                updateSelectedLinearLayout(bnt13)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            bnt14.setOnClickListener {
                updateSelectedLinearLayout(bnt14)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }
            bnt15.setOnClickListener {
                updateSelectedLinearLayout(bnt15)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }
            bnt16.setOnClickListener {
                updateSelectedLinearLayout(bnt16)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }
        }



        // 최초 클릭 이벤트 설정을 호출합니다.
        setClickListeners()

        return view
    }
}
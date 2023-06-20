import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.roomins.R

class MyFragment : Fragment() {
    private lateinit var linearLayoutGroup1: LinearLayout
    private lateinit var linearLayoutGroup2: LinearLayout
    private lateinit var linearLayoutGroup3: LinearLayout
    private lateinit var linearLayoutGroup4: LinearLayout
    private lateinit var linearLayoutGroup5: LinearLayout
    private lateinit var linearLayoutGroup6: LinearLayout
    private lateinit var linearLayoutGroup7: LinearLayout
    private lateinit var linearLayoutGroup8: LinearLayout
    private var selectedLinearLayout: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)

        linearLayoutGroup1 = view.findViewById(R.id.linear_layout_group1)
        linearLayoutGroup2 = view.findViewById(R.id.linear_layout_group2)
        linearLayoutGroup3 = view.findViewById(R.id.linear_layout_group3)
        linearLayoutGroup4 = view.findViewById(R.id.linear_layout_group4)
        linearLayoutGroup5 = view.findViewById(R.id.linear_layout_group5)
        linearLayoutGroup6 = view.findViewById(R.id.linear_layout_group6)
        linearLayoutGroup7 = view.findViewById(R.id.linear_layout_group7)
        linearLayoutGroup8 = view.findViewById(R.id.linear_layout_group8)
        // LinearLayout 선택 시 호출되는 함수
        fun updateSelectedLinearLayout(linearLayout: LinearLayout) {
            selectedLinearLayout?.setBackgroundColor(Color.TRANSPARENT) // 이전에 선택한 LinearLayout의 배경색을 원래대로 되돌립니다.
            selectedLinearLayout = linearLayout
            selectedLinearLayout?.setBackgroundColor(Color.parseColor("#FFF0F3")) // 선택한 LinearLayout의 배경색을 변경합니다.
        }

        // 클릭 이벤트를 설정하는 함수를 정의합니다.
        fun setClickListeners() {
            linearLayoutGroup1.setOnClickListener {
                updateSelectedLinearLayout(linearLayoutGroup1)
            }

            linearLayoutGroup2.setOnClickListener {
                updateSelectedLinearLayout(linearLayoutGroup2)
            }

            linearLayoutGroup3.setOnClickListener {
                updateSelectedLinearLayout(linearLayoutGroup3)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            linearLayoutGroup4.setOnClickListener {
                updateSelectedLinearLayout(linearLayoutGroup4)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            linearLayoutGroup5.setOnClickListener {
                updateSelectedLinearLayout(linearLayoutGroup5)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            linearLayoutGroup6.setOnClickListener {
                updateSelectedLinearLayout(linearLayoutGroup6)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            linearLayoutGroup7.setOnClickListener {
                updateSelectedLinearLayout(linearLayoutGroup7)
                val loadingDialog = LoadingDialog(requireContext())
                loadingDialog.show()
            }

            linearLayoutGroup8.setOnClickListener {
                updateSelectedLinearLayout(linearLayoutGroup8)
            }
        }



        // 최초 클릭 이벤트 설정을 호출합니다.
        setClickListeners()

        return view
    }
}

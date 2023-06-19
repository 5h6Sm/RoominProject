package com.example.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.roomins.R

class CheckOut : Fragment() {
    private lateinit var checkInRadioButton: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        val radioGroup = view.findViewById<RadioGroup>(R.id.toggle)
        checkInRadioButton = view.findViewById<RadioButton>(R.id.search)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.search -> {
                    navigateToCheckInFragment()
                }
            }
        }

        return view
    }

    private fun navigateToCheckInFragment() {
        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.popBackStack()
    }
}
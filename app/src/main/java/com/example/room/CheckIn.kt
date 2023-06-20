package com.example.room

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.roomins.R

class CheckIn : Fragment() {
    private lateinit var checkOutRadioButton: RadioButton
    private lateinit var passportButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_roomin, container, false)

        val radioGroup = view.findViewById<RadioGroup>(R.id.toggle)
        checkOutRadioButton = view.findViewById<RadioButton>(R.id.offer)

        passportButton = view.findViewById(R.id.passportButton)
        passportButton.setOnClickListener {
            navigateToActivityXml()
        }
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.offer -> {
                    navigateToCheckOutFragment()
                }
            }
        }

        return view
    }

    private fun navigateToCheckOutFragment() {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val checkOutFragment = CheckOut()
        transaction.replace(R.id.fragment_container, checkOutFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun navigateToActivityXml() {
        val intent = Intent(requireContext(), Passport::class.java)
        startActivity(intent)
    }
}
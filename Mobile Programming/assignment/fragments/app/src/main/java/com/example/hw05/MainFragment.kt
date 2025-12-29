package com.example.hw05

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null

    // communicate with main activity
    interface Callbacks {
        // pass info to main activity when next button is triggered.
        fun onNextButtonClicked(name: String, age: String, studentId: String)
    }

    private var callbacks: Callbacks? = null

    // connect callback to main activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        // avoid memory leakage
        callbacks = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentMainBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        // set click listener for next button.
        // get information from input fields and pass to main activity.
        fragmentBinding.nextButton.setOnClickListener {
            val name = fragmentBinding.nameEditText.text.toString()
            val age = fragmentBinding.ageEditText.text.toString()
            val studentId = fragmentBinding.studentIdEditText.text.toString()
            callbacks?.onNextButtonClicked(name, age, studentId)
        }

        return fragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // avoid memory leakage
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}

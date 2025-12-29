package com.example.hw05

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentAddressBinding

class AddressFragment : Fragment() {
    private var binding: FragmentAddressBinding? = null

    // communicate with main activity using callbacks
    interface Callbacks {
        fun onDoneButtonClicked(city: String, postalCode: String, address: String)
    }

    private var callbacks: Callbacks? = null

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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentAddressBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        // click listener for done button
        // get information from input fields and pass to main activity
        fragmentBinding.submitButton.setOnClickListener {
            val city = fragmentBinding.cityEditText.text.toString()
            val postalCode = fragmentBinding.postalCodeEditText.text.toString()
            val address = fragmentBinding.addressEditText.text.toString()
            callbacks?.onDoneButtonClicked(city, postalCode, address)
        }

        return fragmentBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // avoid memory leakage
        binding = null
    }

    companion object {
        fun newInstance() = AddressFragment()
    }
}
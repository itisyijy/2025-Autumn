package com.example.hw05

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw05.databinding.FragmentSubBinding

class SubFragment : Fragment() {

    private var binding: FragmentSubBinding? = null

    // only welcome message in initial view
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentSubBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    // method called by main activity
    fun updateInfo(userInfo: UserInfo) {
        binding?.let {
            // hide welcome message
            it.welcomeTextView.visibility = View.GONE

            // display user information & confirmation messages
            it.confirmationTitle.visibility = View.VISIBLE
            it.nameTextView.visibility = View.VISIBLE
            it.reviewDataMessage.visibility = View.VISIBLE
            it.otherInfoTextView.visibility = View.VISIBLE

            // retrieve user information from data class UserInfo
            it.nameTextView.text = userInfo.name
            it.otherInfoTextView.text = "${userInfo.studentId} ${userInfo.age} ${userInfo.city}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // avoid memory leakage
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = SubFragment()
    }
}
package com.example.hw05

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.hw05.databinding.ActivityMainBinding

// Implementing MainFragment.Callbacks, AddressFragment.Callbacks
class MainActivity : AppCompatActivity(), MainFragment.Callbacks, AddressFragment.Callbacks {
    // late initialization of binding
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var userInfo = UserInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // add SubFragment at the bottom
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(binding.subFrag.id, SubFragment.newInstance())
            }
        }

        // button(add new member) click -> add mainFragment if empty mainFrag
        binding.button.setOnClickListener {
            if (supportFragmentManager.findFragmentById(binding.mainFrag.id) == null) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add(binding.mainFrag.id, MainFragment.newInstance())
                }
            }
        }
    }

    override fun onNextButtonClicked(name: String, age: String, studentId: String) {
        // store personal info in data class UserInfo if next button is clicked.
        userInfo = userInfo.copy(name = name, age = age, studentId = studentId)

        // replace mainFragment with addressFragment
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.mainFrag.id, AddressFragment.newInstance())
            addToBackStack(null)
        }
    }

    override fun onDoneButtonClicked(city: String, postalCode: String, address: String) {
        // store address info in data class UserInfo if done button is clicked.
        userInfo = userInfo.copy(city = city, postalCode = postalCode, address = address)

        // pass userInfo to subFragment
        val subFragment =
            supportFragmentManager.findFragmentById(binding.subFrag.id) as? SubFragment
        subFragment?.updateInfo(userInfo)
    }
}
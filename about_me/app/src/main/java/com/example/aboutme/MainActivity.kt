package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName = UserName("Bishrut")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.userName = myName

        binding.doneButton.setOnClickListener {
            val currentNick = binding.nicknameEdit.text
            addNickName(currentNick)
        }


        setContentView(binding.root)
    }

    private fun addNickName(nickname: Editable) {
        if (nickname.isNotBlank()) {
            binding.apply {
                userName?.nickname = nickname.toString()
                invalidateAll()

                nicknameText.visibility = View.VISIBLE
                nicknameEdit.visibility = View.GONE
                doneButton.visibility = View.GONE
            }
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }
}
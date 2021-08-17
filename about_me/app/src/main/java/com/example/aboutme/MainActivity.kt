package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nicknameEdit: EditText
    private lateinit var nicknameText: TextView
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nicknameEdit = findViewById(R.id.nickname_edit)
        nicknameText = findViewById(R.id.nickname_text)
        doneButton = findViewById(R.id.done_button)

        doneButton.setOnClickListener {
            val currentNick = nicknameEdit.text
            addNickName(currentNick)
        }
    }

    private fun addNickName(nickname: Editable) {

        if (nickname.isNotBlank()) {
            nicknameText.text = nickname

            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }
}
package dev.ogabek.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import android.view.KeyEvent

import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var tempTextView: TextView
    private lateinit var tempTextKey: TextView
    private lateinit var textInputEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {
        tempTextView = findViewById(R.id.tv_temp_text)
        tempTextKey = findViewById(R.id.tv_temp_key)
        textInputEditText = findViewById(R.id.et_text_input)

        textInputEditText.addTextChangedListener {
            tempTextView.text = it.toString()
        }

        textInputEditText.setOnKeyListener { _, keyCode, _ ->

            tempTextKey.text = keyCode.toString()

            if (keyCode == 66) {
                Toast.makeText(applicationContext, "You Pressed Enter Key", Toast.LENGTH_SHORT).show()
                textInputEditText.setText("")
            }

            false
        }

    }
}
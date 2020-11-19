package com.ex.chatinputfield1

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.chatinput_field.*

class MainActivity : AppCompatActivity() {
    lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        val input_text : EditText = findViewById(R.id.input_field)

        val text_send : TextView = findViewById(R.id.send)
        text_send.setOnClickListener {
            val str : String = input_text.text.toString()
            if(str.isNotEmpty()){
                Toast.makeText(this, "Input is: $str", Toast.LENGTH_SHORT).show()
                input_text.text.clear()
            }

        }

        input_text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                text_send.setTextColor(ContextCompat.getColor(context,R.color.before_color))
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(input_text.text.toString().isNotEmpty()){
                    text_send.setTextColor(ContextCompat.getColor(context,R.color.after_color))
                }else{
                    text_send.setTextColor(ContextCompat.getColor(context,R.color.before_color))
                }
            }
        })


        text_send.setTextColor(ContextCompat.getColor(context,R.color.before_color))
        emogy.setOnClickListener {
            Toast.makeText(this, "Emogy Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
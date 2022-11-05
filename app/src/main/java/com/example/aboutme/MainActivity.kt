package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName= MyName("Osama Farahat")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName= myName
   //     findViewById<Button>(R.id.done).setOnClickListener {
  //          addNickname(it)
  //      }
        binding.done.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {

            invalidateAll()
            myName?.nickname=inNickName.text.toString()
    //    binding.nicknameView.text=binding.inNickName.text
        binding.inNickName.visibility=View.GONE
        binding.done.visibility=View.GONE
        binding.nicknameView.visibility=View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
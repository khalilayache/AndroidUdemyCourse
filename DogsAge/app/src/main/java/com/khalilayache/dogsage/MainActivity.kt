package com.khalilayache.dogsage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val dogsAgeEditText: EditText by lazy { findViewById(R.id.dogsAgeEditText) as EditText }
    private val calculateButton: Button by lazy { findViewById(R.id.calculateButton) as Button }
    private val humanAgeTextView: TextView by lazy { findViewById(R.id.humanAgeTextView) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
    }

    private fun initListeners() {
        calculateButton.setOnClickListener {
            if (dogsAgeEditText.text.isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.inform_dog_age), Toast.LENGTH_LONG).show()
            } else {
                val dogAge =  dogsAgeEditText.text.toString().toInt()
                val humanAge = dogAge.times(7)
                this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                humanAgeTextView.text = getString(R.string.dog_human_age,humanAge)
            }
        }
    }

}




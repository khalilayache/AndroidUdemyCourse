package com.khalilayache.selectfood

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  private val radioGroup by lazy { findViewById(R.id.radioGroup) as RadioGroup }
  private val button by lazy { findViewById(R.id.button) as Button }
  private val textView by lazy { findViewById(R.id.result) as TextView }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initListeners()
  }

  private fun initListeners() {
    button.setOnClickListener {
      textView.text = if (radioGroup.checkedRadioButtonId > 0) {
        val radioButton = findViewById(radioGroup.checkedRadioButtonId) as RadioButton
        radioButton.text
      } else ""

    }
  }
}

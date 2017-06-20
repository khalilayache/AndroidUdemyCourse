package com.khalilayache.togglebutton

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
  private val toggleButton by lazy { findViewById(R.id.toggleButton) as ToggleButton }
  private val textView by lazy { findViewById(R.id.textView2) as TextView }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initListeners()
  }

  private fun initListeners() {
    toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
      textView.text = if (isChecked) "Mostrar..." else ""


    }
  }
}

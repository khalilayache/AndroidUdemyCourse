package com.khalilayache.colorpreference

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {


  private val rootLayout by lazy { findViewById(R.id.rootLayout) as ConstraintLayout }
  private val radioGroup by lazy { findViewById(R.id.radioGroup) as RadioGroup }
  private val saveButton by lazy { findViewById(R.id.saveButton) as Button }
  private val sharedPref by lazy { getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE) }


  private val PREFERENCES = "shared_pref"
  private val COLOR_PREF = "color"
  private val DEFAULT_COLOR = "White"
  private val map = mapOf(
      "Blue" to "#577AE4",
      "Orange" to "#FF8000",
      "Green" to "#14BFB2",
      "White" to "#FFFFFF"
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initActivity()
    initListeners()
  }

  private fun initListeners() {
    saveButton.setOnClickListener {
      if (radioGroup.checkedRadioButtonId > 0) {
        saveColorOnPreferences()
        changeBackground(map[getColor()]!!)
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
      }
    }
  }

  private fun changeBackground(color: String) {
    rootLayout.setBackgroundColor(Color.parseColor(color))
  }

  private fun saveColorOnPreferences() {
    val editor = sharedPref.edit()
    val color = getColor()
    editor.putString(COLOR_PREF, map[color])
    editor.apply()
  }

  private fun getColor(): Any? {
    val radioButton = findViewById(radioGroup.checkedRadioButtonId) as RadioButton
    return radioButton.tag
  }

  private fun initActivity() {
    retrieveColorPreferences().let {
      changeBackground(it)
    }
  }

  private fun retrieveColorPreferences(): String {
      return sharedPref.getString(COLOR_PREF, DEFAULT_COLOR )
  }
}

package com.khalilayache.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

  companion object {
    private val PREFERENCES = "shared_pref"
    private val PREFERENCES_NAME = "name"

  }

  private val editText by lazy { findViewById(R.id.nameEdit) as EditText }
  private val textView by lazy { findViewById(R.id.nameText) as TextView }
  private val button by lazy { findViewById(R.id.button) as Button }

  private lateinit var sharedPreferences: SharedPreferences
  private val userDefault = "undefined user"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initActivity()
    initListeners()
  }

  private fun initActivity() {
    sharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    if (sharedPreferences.contains(PREFERENCES_NAME)){
      textView.text = "Hello, ${sharedPreferences.getString(PREFERENCES_NAME, userDefault)}"
    } else {
      textView.text = "Hello, $userDefault"
    }
  }

  private fun initListeners() {
    button.setOnClickListener {
      saveSharedPreferences()
    }
  }

  private fun saveSharedPreferences() {
    val editor = sharedPreferences.edit()

    if (editText.text.toString() == "") {
      Toast.makeText(this, "Please, input your name", Toast.LENGTH_SHORT).show()
    } else {
      editor.putString(PREFERENCES_NAME, editText.text.toString())
      editor.apply()
      textView.text = "Hello, ${editText.text}"
    }
  }

}

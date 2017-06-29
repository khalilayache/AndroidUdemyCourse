package com.khalilayache.annotations

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {

  private val note by lazy { findViewById(R.id.note) as EditText }
  private val save by lazy { findViewById(R.id.save) as ImageView }

  private val FILE_NAME = "annotation.txt"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initActivity()
    initListeners()
  }

  private fun initActivity() {
    note.setText(readFile())
  }

  private fun readFile(): String {
    var result = ""

    try {
      val file = openFileInput(FILE_NAME)
      if (file != null) {
        val input = InputStreamReader(file)
        val buffer = BufferedReader(input)
        var fileLine = buffer.readLine()
        if (fileLine != null) {
          result = fileLine
          while (buffer.readLine() != null) {
            result += buffer.readLine()
          }
        }
        file.close()
      }

    } catch (e: Exception) {
      e.printStackTrace()
    }
    return  result
  }

  private fun initListeners() {
    save.setOnClickListener {
      saveFile(note.text.toString())
      Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show()
    }
  }

  private fun saveFile(text: String) {
    val openFile = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
    val saverFile = OutputStreamWriter(openFile)
    saverFile.write(text)
    saverFile.close()
  }
}

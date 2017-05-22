package com.khalilayache.listview

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : Activity() {

  val listItems by lazy { findViewById(R.id.listView) as ListView }
  val items = arrayOf("Angra dos Reis", "Brasilia", "Campos do Jordão", "Dublin",
      "E", "Florianopolis", "Gramado", "Hamburgo", "Iemen")


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items)
    listItems.adapter = adapter!!


    listItems.setOnItemClickListener { parent, view, position, id ->
      Toast.makeText(this,items[position], Toast.LENGTH_SHORT).show()
    }
  }
}

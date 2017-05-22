package com.khalilayache.signs

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : Activity() {

  val signList by lazy { findViewById(R.id.listView) as ListView }
  val signListItens = arrayOf("Aries", "Touro", "Cancer", "Leão", "Virgem",
      "Libra", "Escorpião", "Sagitario", "Capricornio", "Aquario", "Peixes")

  val profileListItens = arrayOf("Perfil 1", "Perfil 2", "Perfil 3", "Perfil 4", "Perfil 5", "Perfil 6",
      "Perfil 7", "Perfil 8", "Perfil 9", "Perfil 10", "Perfil 11", "Perfil 12")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, signListItens)
    signList.adapter = adapter!!

    signList.setOnItemClickListener { parent, view, position, id ->
      Toast.makeText(this, profileListItens[position], Toast.LENGTH_SHORT).show()
    }

  }
}

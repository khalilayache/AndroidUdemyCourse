package com.khalilayache.sqlite

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log


class MainActivity : AppCompatActivity() {

  private val database by lazy { openOrCreateDatabase("app", MODE_PRIVATE, null) }
  private val cursor by lazy { database.rawQuery("SELECT name, age FROM pessoas ", null) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    try {
      database.execSQL("CREATE TABLE IF NOT EXISTS pessoas(name VARCHAR, age INT(3) ) ")

      database.execSQL("INSERT INTO pessoas (name, age) VALUES ('Marcos', 30) ")
      database.execSQL("INSERT INTO pessoas (name, age) VALUES ('Ana', 20) ")

      val columnIndexName = cursor.getColumnIndex("name")
      val columnIndexAge = cursor.getColumnIndex("age")

      cursor.moveToFirst()

      while (!cursor.isLast) {
        Log.i("Result - name: ", cursor.getString(columnIndexName))
        Log.i("Result - age: ", cursor.getString(columnIndexAge))

        cursor.moveToNext()
      }
    } catch(e: Exception) {
      e.printStackTrace()
    } finally {
      database.close()
    }
  }
}

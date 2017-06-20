package com.khalilayache.whatseries

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.SeekBar


class MainActivity : AppCompatActivity() {

  private val seekBar by lazy { findViewById(R.id.seekBar) as SeekBar }
  private val statusImage by lazy { findViewById(R.id.statusImage) as ImageView }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initActivity()
  }

  private fun initActivity() {
    seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
      override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        when (progress) {
          0 -> statusImage.setImageResource(android.R.color.transparent)
          1 -> statusImage.setImageResource(R.drawable.pouco)
          2 -> statusImage.setImageResource(R.drawable.medio)
          3 -> statusImage.setImageResource(R.drawable.muito)
          4 -> statusImage.setImageResource(R.drawable.susto)
        }
      }

      override fun onStartTrackingTouch(seekBar: SeekBar?) {
      }

      override fun onStopTrackingTouch(seekBar: SeekBar?) {
      }


    })
  }
}


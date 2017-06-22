package com.khalilayache.animalssound

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private val dog by lazy { findViewById(R.id.dog) as ImageView }
  private val cat by lazy { findViewById(R.id.cat) as ImageView }
  private val lion by lazy { findViewById(R.id.lion) as ImageView }
  private val monkey by lazy { findViewById(R.id.monkey) as ImageView }
  private val sheep by lazy { findViewById(R.id.sheep) as ImageView }
  private val cow by lazy { findViewById(R.id.cow) as ImageView }

  private var mediaPlayer: MediaPlayer? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initListeners()
  }

  private fun initListeners() {
    dog.setOnClickListener(this)
    cat.setOnClickListener(this)
    lion.setOnClickListener(this)
    monkey.setOnClickListener(this)
    sheep.setOnClickListener(this)
    cow.setOnClickListener(this)
  }

  override fun onClick(view: View?) {
    view?.let { playAnimalSound(map[it.id]) }
  }

  private fun playAnimalSound(rawID: Int?) {
    if (rawID == null) return

    mediaPlayer?.stop()
    mediaPlayer?.release()
    mediaPlayer = MediaPlayer.create(this, rawID)
    mediaPlayer?.start()

  }

  companion object {
    val map = mapOf(
        R.id.dog to R.raw.dog,
        R.id.cat to R.raw.cat,
        R.id.lion to R.raw.lion,
        R.id.monkey to R.raw.monkey,
        R.id.sheep to R.raw.sheep,
        R.id.cow to R.raw.cow
    )
  }
}

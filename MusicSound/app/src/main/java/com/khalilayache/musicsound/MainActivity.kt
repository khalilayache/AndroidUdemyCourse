package com.khalilayache.musicsound

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

  private val button by lazy { findViewById(R.id.button) as Button }
  private lateinit var mediaPlayer: MediaPlayer

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initActivity()
  }

  private fun initActivity() {
    mediaPlayer = MediaPlayer.create(this, R.raw.musica)
    button.setOnClickListener {
      if (mediaPlayer.isPlaying){
        playMusic()
      }else{
        pauseMusic()
      }
    }
  }

  private fun playMusic() {
    button.text = "Pause"
    mediaPlayer.start()
  }

  private fun pauseMusic() {
    button.text = "Play"
    mediaPlayer.pause()
  }

  override fun onDestroy() {
    super.onDestroy()
    mediaPlayer.apply {
      stop()
      release()
    }
  }
}

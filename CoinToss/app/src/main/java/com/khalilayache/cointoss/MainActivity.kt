package com.khalilayache.cointoss

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val playImageView: ImageView by lazy { findViewById(R.id.playImageView) as ImageView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        playImageView.setOnClickListener{
            val numSorted = Random().nextInt(2)
            DetailsActivity.start(this,numSorted)
        }
    }
}

package com.khalilayache.cointoss

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class DetailsActivity : AppCompatActivity() {

    val NUMBER_SORTED = "NUMBER_SORTED"

    private val backImageView: ImageView by lazy { findViewById(R.id.backImageView) as ImageView }
    private val coinImageView: ImageView by lazy { findViewById(R.id.coinImageView) as ImageView }
    val coinToss: Array<Int> = arrayOf(R.drawable.moeda_cara, R.drawable.moeda_coroa)

    var numSorted: Int = 0

    companion object{
        fun start(context: Context, num: Int){
            val intent = Intent(context,DetailsActivity::class.java)
                    .putExtra("NUMBER_SORTED", num)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initListener()
        initView()
    }

    private fun initView() {
        numSorted = intent.getIntExtra("NUMBER_SORTED", 0)
        coinImageView.setImageResource(coinToss[numSorted])
    }

    private fun initListener() {
        backImageView.setOnClickListener {
            onBackPressed()
        }
    }
}

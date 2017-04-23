package com.khalilayache.gasoralcohol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val gasPriceEditText: EditText by lazy { findViewById(R.id.gasPrice) as EditText }
    private val alcoholPriceEditText: EditText by lazy { findViewById(R.id.alcoholPrice) as EditText }
    private val checkButton: Button by lazy { findViewById(R.id.check) as Button }
    private val resultTextView: TextView  by lazy { findViewById(R.id.result) as TextView }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        checkButton.setOnClickListener {
            if(gasPriceEditText.text.isNullOrEmpty() or alcoholPriceEditText.text.isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.inform_both),Toast.LENGTH_LONG).show()
            } else {
                val result = alcoholPriceEditText.text.toString()
                        .toDouble().div(
                        gasPriceEditText.text.toString().toDouble())
                if (result >= 0.7) {
                    resultTextView.text = getString(R.string.better_gas)
                } else {
                    resultTextView.text = getString(R.string.better_alcohol)
                }
            }
        }
    }
}

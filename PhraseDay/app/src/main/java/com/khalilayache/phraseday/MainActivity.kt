package com.khalilayache.phraseday

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find
import java.util.Random

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newPhraseButton: Button = find(R.id.newPhraseButton)
        val newPhraseTextView: TextView = find(R.id.newPhraseTextView)
        val phrases: Array<String> = arrayOf("Phrase 1",
                "Phrase 2",
                "Phrase 3",
                "Phrase 4",
                "Phrase 5")

        newPhraseButton.setOnClickListener {
            val random = Random()
            val randomNumber = random.nextInt(phrases.size)
            newPhraseTextView.text = phrases[randomNumber]


        }

    }
}

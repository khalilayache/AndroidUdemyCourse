package com.khalilayache.atmconsulting.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.khalilayache.atmconsulting.R

class CompanyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company)
    }

    companion object{
        fun start(context: Context){
            val intent = Intent(context, CompanyActivity::class.java)
            context.startActivity(intent)
        }
    }
}

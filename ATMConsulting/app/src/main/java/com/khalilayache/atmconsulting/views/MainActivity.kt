package com.khalilayache.atmconsulting.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.khalilayache.atmconsulting.R

class MainActivity : AppCompatActivity() {

    private val companyImageView: ImageView by lazy { findViewById(R.id.companyImageView) as ImageView }
    private val contactImageView: ImageView by lazy { findViewById(R.id.contactImageView) as ImageView }
    private val clientsImageView: ImageView by lazy { findViewById(R.id.clientsImageView) as ImageView }
    private val servicesImageView: ImageView by lazy { findViewById(R.id.servicesImageView) as ImageView }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }


    private fun initListeners() {
        companyImageView.setOnClickListener {
            CompanyActivity.start(this)
        }

        servicesImageView.setOnClickListener {
            ServicesActivity.start(this)
        }
        contactImageView.setOnClickListener {
            ContactActivity.start(this)
        }

        clientsImageView.setOnClickListener {
           ClientsActivity.start(this)
        }
    }


}

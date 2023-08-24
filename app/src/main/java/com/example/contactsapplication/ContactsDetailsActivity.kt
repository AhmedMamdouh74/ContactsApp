package com.example.contactsapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactsDetailsActivity : AppCompatActivity() {
    var name: TextView? = null
    var phone: TextView? = null
    var description: TextView? = null
    var back:ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_details)
        name = findViewById(R.id.tv_details_name)
        phone = findViewById(R.id.tv_details_phone)
        description = findViewById(R.id.tv_details_description)
        back=findViewById(R.id.iv_back)
        intent.getStringExtra("name")
        intent.getStringExtra("phone")
        intent.getStringExtra("description")
        name?.text = intent.getStringExtra("name")
        phone?.text = intent.getStringExtra("phone")
        description?.text = intent.getStringExtra("description")
        back?.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
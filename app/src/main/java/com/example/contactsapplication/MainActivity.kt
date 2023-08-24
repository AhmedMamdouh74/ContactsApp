package com.example.contactsapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var phone: TextView
    lateinit var description: TextView
    lateinit var save: Button
    lateinit var contactsRecyclerView: RecyclerView
    lateinit var contactsAdapter: ContactsAdapter
    lateinit var contactsitems: MutableList<ContactsItems>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.ed_name)
        phone = findViewById(R.id.ed_phoneNumber)
        description = findViewById(R.id.ed_description)
        save = findViewById(R.id.btn_save)
        contactsRecyclerView = findViewById(R.id.contact_recycler)
        contactsitems = mutableListOf()
        contactsAdapter = ContactsAdapter(contactsitems)
        contactsRecyclerView.adapter = contactsAdapter
        save.setOnClickListener {
            val contactName = name.text.toString().trim { it <= ' ' }
            val contactPhone = phone.text.toString().trim { it <= ' ' }
            val contactDescription = description.text.toString().trim { it <= ' ' }
            if (name.length() < 3) {
                Toast.makeText(
                    this@MainActivity,
                    "name should be 3 chars or more",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (phone.length() != 11) {
                Toast.makeText(this@MainActivity, "phone should be 11 numbers", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val items = ContactsItems(contactName, contactPhone, contactDescription)
                contactsitems.add(items)
                contactsAdapter.notifyDataSetChanged()
                name.text = ""
                phone.text = ""
                description.text = ""
            }
        }

        contactsAdapter.onContactClickListener =
            ContactsAdapter.OnContactClickListener { items, position ->
                val intent = Intent(this@MainActivity, ContactsDetailsActivity::class.java)
                intent.putExtra("name", items.name)
                intent.putExtra("phone", items.phone)
                intent.putExtra("description", items.description)
                startActivity(intent)
            }

    }

}
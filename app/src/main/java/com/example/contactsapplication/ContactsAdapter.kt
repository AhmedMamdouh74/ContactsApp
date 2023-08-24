package com.example.contactsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ContactsAdapter(var contactsItems: MutableList<ContactsItems>) :
    Adapter<ContactsAdapter.ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.contacts_details_item_layout, parent, false)
        return ContactsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactsItems.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var items: ContactsItems = contactsItems[position]
        holder.name.text = items.name
        holder.phone.text = items.phone
        if (onContactClickListener != null) {
            holder.avatar.setOnClickListener {
                onContactClickListener.onContactClick(items,position)

            }
        }

    }


    lateinit var onContactClickListener: OnContactClickListener

    fun interface OnContactClickListener {
        fun onContactClick(itemView: ContactsItems, position: Int)

    }

    class ContactsViewHolder(itemView: View) : ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var phone: TextView = itemView.findViewById(R.id.tv_phoneNumber)
        var avatar: ImageView = itemView.findViewById(R.id.avatar)
    }
}

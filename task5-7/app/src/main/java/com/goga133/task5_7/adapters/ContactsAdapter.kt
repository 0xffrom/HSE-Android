package com.goga133.task5_7.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goga133.task5_7.R
import com.goga133.task5_7.models.ContactCard
import kotlinx.android.synthetic.main.holder_contact.view.*

class ContactsAdapter(private var data: ArrayList<ContactCard>) :
    RecyclerView.Adapter<ContactsAdapter.ContactsHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ContactsHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.id_user
        val name: TextView = itemView.name_user
        val phone: TextView = itemView.phone_user
    }

    public fun setNewData(data: ArrayList<ContactCard>){
        this.data = data;
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactsAdapter.ContactsHolder {
        return ContactsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.holder_contact, parent, false)
        )
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ContactsHolder, position: Int) {
        holder.name.text = data[position].displayName
        holder.phone.text = data[position].number
        holder.id.text = data[position].id;
    }

    override fun getItemCount() = data.size;
}

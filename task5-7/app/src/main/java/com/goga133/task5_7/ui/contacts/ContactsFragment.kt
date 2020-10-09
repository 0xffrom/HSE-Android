package com.goga133.task5_7.ui.contacts

import android.Manifest
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.goga133.task5_7.R
import com.goga133.task5_7.adapters.ContactsAdapter
import com.goga133.task5_7.models.ContactCard
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.fragment_contacts.view.*


class ContactsFragment : Fragment() {

    private lateinit var contactsViewModel: ContactsViewModel


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactsViewModel =
            ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contacts, container, false)


        val viewManager = LinearLayoutManager(context)
        val adapter = ContactsAdapter(arrayListOf());

        root.recyclerView.apply {
            this.setHasFixedSize(false)
            this.layoutManager = viewManager
            this.adapter = adapter;
        }

        root.button_import.setOnClickListener {
            importContacts()
        }

        contactsViewModel.dataContacts.observe(viewLifecycleOwner, Observer {
            adapter.setNewData(it);
        })


        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun importContacts() {
        button_import.visibility = View.GONE;

        val readContactsPermission = ContextCompat.checkSelfPermission(
            requireContext(), Manifest.permission.READ_CONTACTS
        )
        if (readContactsPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                PERMISSION_GRANTED
            );
        }

        contactsViewModel.loadDataContacts(requireActivity());
    }


}
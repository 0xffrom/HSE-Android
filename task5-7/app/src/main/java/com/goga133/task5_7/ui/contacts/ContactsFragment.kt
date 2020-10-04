package com.goga133.task5_7.ui.contacts

import android.Manifest
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.goga133.task5_7.R
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

        root.button_import.setOnClickListener {
            importContacts()
        }
/*        contactsViewModel.text.observe(viewLifecycleOwner, Observer {
            //
        })*/


        return root
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun importContacts() {
        val readContactsPermission = ContextCompat.checkSelfPermission(
            requireContext(), Manifest.permission.READ_CONTACTS
        )
        if (readContactsPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                PERMISSION_GRANTED
            );
        }

// Query the content provider using the generated URI.
        var cursor = requireContext().applicationContext.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null
        )

        val from = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID
        )

        activity?.startManagingCursor(cursor)
// Print any results found using the work profile contacts' display name.
        cursor?.use {
            while (it.moveToNext()) {
                Log.i(
                    TAG,
                    "Work profile contact: ${
                        it.columnNames.}")
                        }
                        }

    }


}
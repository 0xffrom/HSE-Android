package com.goga133.task5_7.ui.contacts

import android.app.Activity
import android.content.ContentResolver
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goga133.task5_7.models.ContactCard

class ContactsViewModel : ViewModel() {

    private val _dataContacts = MutableLiveData<ArrayList<ContactCard>>();

    val dataContacts: LiveData<ArrayList<ContactCard>> = _dataContacts

    public fun loadDataContacts(activity: Activity) {
        val resolver: ContentResolver? = activity.contentResolver;
        val cursor = resolver?.query(
            ContactsContract.Contacts.CONTENT_URI, null, null, null,
            null
        )!!

        val contactCards = ArrayList<ContactCard>();
        while (cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
            val name =
                cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            var phoneNumValue: String = ""
            val phoneNumber = (cursor.getString(
                cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)
            )).toInt()

            if (phoneNumber > 0) {
                val cursorPhone = resolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                    arrayOf(id),
                    null
                )

                if (cursorPhone != null) {
                    if (cursorPhone.count > 0) {
                        while (cursorPhone.moveToNext()) {
                            phoneNumValue = cursorPhone.getString(
                                cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            )
                        }
                    }
                }
                cursorPhone?.close()
                contactCards.add(

                    ContactCard(
                        name, phoneNumValue, id
                    )
                )
            }
        }
        cursor.close()

        _dataContacts.value = contactCards;
    }
}
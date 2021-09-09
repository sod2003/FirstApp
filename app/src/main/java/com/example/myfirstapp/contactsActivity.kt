package com.example.myfirstapp

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import android.R.attr.data
import android.database.Cursor
import android.R.attr.data


class contactsActivity : AppCompatActivity() {
    lateinit var editName: EditText
    lateinit var viewName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        editName = findViewById(R.id.editContact)
        viewName = findViewById(R.id.viewContact)
    }

    fun selectContact() {
        val intent = Intent(Intent.ACTION_PICK).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 1)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val contactUri: Uri? = data?.data
            viewName.setText(contactUri.toString())
        }
    }


    fun insertContact(name: String, phone: String) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, name)
            putExtra(ContactsContract.Intents.Insert.PHONE, phone)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}
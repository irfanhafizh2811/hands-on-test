package com.android.myapplication.contact.ui.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.android.myapplication.contact.repository.ContactRepository

class AddContactViewModel(private val repository: ContactRepository, val app: Application) :
    AndroidViewModel(app) {

}
package com.android.myapplication.contact.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.android.myapplication.contact.repository.ContactRepository

class DetailContactViewModel(private val repository: ContactRepository, val app: Application) :
    AndroidViewModel(app) {
}
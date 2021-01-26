package com.android.myapplication.contact.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.android.myapplication.contact.repository.ContactRepository

class MainContactViewModel(private val repository: ContactRepository, val app: Application) :
    AndroidViewModel(app) {



}
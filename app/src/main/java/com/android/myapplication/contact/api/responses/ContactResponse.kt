package com.android.myapplication.contact.api.responses

import com.android.myapplication.contact.models.Info
import com.android.myapplication.contact.models.Contact
import com.google.gson.annotations.SerializedName

data class ContactResponse(
    @SerializedName("results")
    val contacts: List<Contact>?,
    @SerializedName("info")
    val info: Info
)
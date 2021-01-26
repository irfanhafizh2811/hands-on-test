package com.android.myapplication.contact.api

import androidx.lifecycle.LiveData
import com.android.myapplication.contact.api.responses.ApiResponse
import com.android.myapplication.contact.api.responses.ContactResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ContactApi {

    @GET("api")
    fun getContacts(
        @Query("results") results: Int = 5,
        @Query("exc") exc: String = "login"
    ): LiveData<ApiResponse<ContactResponse>>

}
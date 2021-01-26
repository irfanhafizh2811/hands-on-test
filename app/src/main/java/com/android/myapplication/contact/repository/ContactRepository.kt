package com.android.myapplication.contact.repository

import androidx.lifecycle.LiveData
import com.android.myapplication.contact.api.ContactApi
import com.android.myapplication.contact.api.responses.ApiResponse
import com.android.myapplication.contact.api.responses.ContactResponse
import com.android.myapplication.contact.models.Contact
import com.android.myapplication.contact.persistence.dao.ContactDao
import com.android.myapplication.contact.util.AppExecutors
import com.android.myapplication.contact.util.NetworkBoundResource
import com.android.myapplication.contact.util.Resource

class ContactRepository(
    private val contactDao: ContactDao,
    private val appExecutors: AppExecutors,
    private val movieApi: ContactApi
) {

    fun getMovieDetail(
        pageNumber: Int
    ): LiveData<Resource<List<Contact>>> {
        return object : NetworkBoundResource<List<Contact>, ContactResponse>(appExecutors) {
            override fun saveCallResult(item: ContactResponse?) {
                item?.let {
                    val list: ArrayList<Contact>? = (item.contacts)?.let { ArrayList(it) }
                    list?.let {
                        contactDao.insertContact(*list.toTypedArray())
                    }
                }
            }

            override fun shouldFetch(data: List<Contact>?): Boolean = true

            override fun loadFromDb(): LiveData<List<Contact>> =
                contactDao.getContacts(pageNumber)

            override fun createCall(): LiveData<ApiResponse<ContactResponse>> =
                movieApi.getContacts()

        }.asLiveData()
    }

}
package com.android.myapplication.contact.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.myapplication.contact.models.Contact

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertContact(vararg contact: Contact): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM contact LIMIT (:pageNumber*20)")
    fun getContacts(pageNumber: Int): LiveData<List<Contact>>

}
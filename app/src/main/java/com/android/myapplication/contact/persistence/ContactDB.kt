package com.android.myapplication.contact.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.myapplication.contact.models.Contact
import com.android.myapplication.contact.persistence.dao.ContactDao

@Database(
    entities = [Contact::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converter::class)
abstract class ContactDB : RoomDatabase() {

    abstract val contactDao: ContactDao

}
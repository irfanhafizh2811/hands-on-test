package com.android.myapplication.contact.persistence

import androidx.room.TypeConverter
import com.android.myapplication.contact.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromId(idLang: Id?): String? {
        val type = object : TypeToken<Id>() {}.type
        return Gson().toJson(idLang, type)
    }

    @TypeConverter
    fun toId(idLang: String?): Id? {
        val type = object : TypeToken<Id>() {}.type
        return Gson().fromJson<Id>(idLang, type)
    }

    @TypeConverter
    fun fromName(idName: Name?): String? {
        val type = object : TypeToken<Name>() {}.type
        return Gson().toJson(idName, type)
    }

    @TypeConverter
    fun toName(idName: String?): Name? {
        val type = object : TypeToken<Name>() {}.type
        return Gson().fromJson<Name>(idName, type)
    }

    @TypeConverter
    fun fromLocation(locationLang: String?): String? {
        val type = object : TypeToken<Location>() {}.type
        return Gson().toJson(locationLang, type)
    }

    @TypeConverter
    fun toLocation(locationLang: String?): Location? {
        val type = object : TypeToken<Location>() {}.type
        return Gson().fromJson<Location>(locationLang, type)
    }

    @TypeConverter
    fun fromDob(dobLang: String?): String? {
        val type = object : TypeToken<Dob>() {}.type
        return Gson().toJson(dobLang, type)
    }

    @TypeConverter
    fun toDob(dobLang: String?): Dob? {
        val type = object : TypeToken<Dob>() {}.type
        return Gson().fromJson<Dob>(dobLang, type)
    }

    @TypeConverter
    fun fromPicture(pictureLang: String?): String? {
        val type = object : TypeToken<Picture>() {}.type
        return Gson().toJson(pictureLang, type)
    }

    @TypeConverter
    fun toPicture(pictureLang: String?): Picture? {
        val type = object : TypeToken<Picture>() {}.type
        return Gson().fromJson<Picture>(pictureLang, type)
    }

}
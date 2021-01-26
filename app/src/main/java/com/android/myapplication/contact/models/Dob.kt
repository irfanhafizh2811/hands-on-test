package com.android.myapplication.contact.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "dob_table")
data class Dob(
    @SerializedName("date") val date: String,
    @SerializedName("age") val age: Int
) : Parcelable
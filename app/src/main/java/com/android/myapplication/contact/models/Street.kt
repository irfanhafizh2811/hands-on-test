package com.android.myapplication.contact.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "street_table")
data class Street(
    @SerializedName("number") val number: Int,
    @SerializedName("name") val name: String
) : Parcelable
package com.android.myapplication.contact.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "id_table")
data class Id(
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("value")
    val value: Int
) : Parcelable
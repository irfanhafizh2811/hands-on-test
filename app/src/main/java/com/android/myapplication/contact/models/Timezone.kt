package com.android.myapplication.contact.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "timezone_table")
data class Timezone(
    @SerializedName("offset") val offset: String,
    @SerializedName("description") val description: String
) : Parcelable
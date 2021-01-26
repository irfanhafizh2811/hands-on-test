package com.android.myapplication.contact.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "contact",
    indices = [Index("email")],
    primaryKeys = ["email"]
)
data class Contact(

    @SerializedName("id") val id: Id,

    @SerializedName("gender") val gender: String,

    @ColumnInfo(name = "category")
    @Embedded(prefix = "name_")
    @SerializedName("name")
    val name: Name,

    @Embedded(prefix = "location_")
    @SerializedName("location")
    val location: Location,

    @SerializedName("email") val email: String,

    @Embedded(prefix = "dob_")
    @SerializedName("dob")
    val dob: Dob,

    @SerializedName("phone") val phone: Int,

    @SerializedName("cell") val cell: Int,

    @Embedded(prefix = "picture_")
    @SerializedName("picture")
    val picture: Picture,

    @SerializedName("nat") val nat: String

) : Parcelable
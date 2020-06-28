package com.sunasterisk.movie19.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Cast(
    @SerializedName("cast_id")
    var castId: Int,
    @SerializedName("character")
    var character: String,
    @SerializedName("credit_id")
    var creditId: String,
    @SerializedName("gender")
    var gender: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("order")
    var order: Int,
    @SerializedName("profile_path")
    var profilePath: String
) : Parcelable

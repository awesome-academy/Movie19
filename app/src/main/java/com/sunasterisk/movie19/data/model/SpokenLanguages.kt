package com.sunasterisk.movie19.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class SpokenLanguages(
    @SerializedName("iso_639_1")
    var iso6391: String,
    @SerializedName("name")
    var name: String
) : Parcelable

package com.sunasterisk.movie19.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class DataCredits(
    @SerializedName("id")
    var id: Int,
    @SerializedName("cast")
    var casts: List<Cast>,
    @SerializedName("crew")
    var crews: List<Crew>
) : Parcelable

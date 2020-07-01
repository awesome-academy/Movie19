package com.sunasterisk.movie19.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class DataVideo(
    @SerializedName("id")
    var id: Int,
    @SerializedName("results")
    var results: List<Video>
) : Parcelable

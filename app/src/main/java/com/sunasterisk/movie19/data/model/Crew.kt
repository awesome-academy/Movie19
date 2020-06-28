package com.sunasterisk.movie19.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Crew(
    @SerializedName("credit_id")
    var creditId: String,
    @SerializedName("department")
    var department: String,
    @SerializedName("gender")
    var gender: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("job")
    var job: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("profile_path")
    var profilePath: String
) : Parcelable

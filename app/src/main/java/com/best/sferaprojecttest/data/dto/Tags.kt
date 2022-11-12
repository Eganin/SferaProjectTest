package com.best.sferaprojecttest.data.dto

import com.google.gson.annotations.SerializedName

data class Tags (
    @SerializedName("tag_id"      ) var tagId       : Int?     = null,
    @SerializedName("name"        ) var name        : String?  = null,
    @SerializedName("description" ) var description : String?  = null,
    @SerializedName("is_nsfw"     ) var isNsfw      : Boolean? = null
)

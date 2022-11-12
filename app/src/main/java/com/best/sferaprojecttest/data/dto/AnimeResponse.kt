package com.best.sferaprojecttest.data.dto

import com.google.gson.annotations.SerializedName

data class AnimeResponse (

    @SerializedName("images" ) var images :List<Images> = arrayListOf()

)

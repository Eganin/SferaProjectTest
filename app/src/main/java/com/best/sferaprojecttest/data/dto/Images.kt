package com.best.sferaprojecttest.data.dto

import com.google.gson.annotations.SerializedName

data class Images (

    @SerializedName("signature"      ) var signature     : String?         = null,
    @SerializedName("extension"      ) var extension     : String?         = null,
    @SerializedName("image_id"       ) var imageId       : Int?            = null,
    @SerializedName("favourites"     ) var favourites    : Int?            = null,
    @SerializedName("dominant_color" ) var dominantColor : String?         = null,
    @SerializedName("source"         ) var source        : String?         = null,
    @SerializedName("uploaded_at"    ) var uploadedAt    : String?         = null,
    @SerializedName("is_nsfw"        ) var isNsfw        : Boolean?        = null,
    @SerializedName("width"          ) var width         : Int?            = null,
    @SerializedName("height"         ) var height        : Int?            = null,
    @SerializedName("url"            ) var url           : String?         = null,
    @SerializedName("preview_url"    ) var previewUrl    : String?         = null,
    @SerializedName("tags"           ) var tags          : ArrayList<Tags> = arrayListOf()

)

package com.best.sferaprojecttest.domain.models

data class ProfileInfo(
    val avatarLink: String,
    val rating: Double,
    val id: String,
    val nickName: String,
    var languages: String ,
    var geolocations: String
)

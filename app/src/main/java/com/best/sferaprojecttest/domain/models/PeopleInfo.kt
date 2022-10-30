package com.best.sferaprojecttest.domain.models

data class PeopleInfo(
    val imageLink : String,
    val title : String,
    val action : PeopleAction
){
    enum class PeopleAction{
        SUBSCRIBE_ACTIVE,
        SUBSCRIBE_INACTIVE,
        UNSUBSCRIBE,
    }
}

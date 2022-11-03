package com.best.sferaprojecttest.domain.models

data class PeopleInfo(
    val imageLink : String,
    val title : String,
    var action : PeopleAction
){
    enum class PeopleAction{
        SUBSCRIBE,
        UNSUBSCRIBE,
    }
}

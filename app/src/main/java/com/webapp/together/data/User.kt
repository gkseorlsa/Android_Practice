package com.webapp.together.data

data class User(
    val nick: String,
    val age: Int,
    val gender: Gender,
    val mbti: String,
    val job: String,
    val hobby: String
)

enum class Gender(val title: String) {
    M("남자"),
    F("여자")
}
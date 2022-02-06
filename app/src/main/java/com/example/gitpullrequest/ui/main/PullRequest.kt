package com.example.gitpullrequest.ui.main

data class PullRequest(
    val number: Int,
    val title: String,
    val body: String,
    val state: State,
    val createdAt: String,
    val updatedAt: String
)

enum class State(val stateStr: String){
    OPEN("open"), CLOSED("closed")
}

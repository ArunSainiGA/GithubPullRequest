package com.example.gitpullrequest.data.response

data class PullRequestResponse(
    val number: Int? = 0,
    val title: String? = null,
    val body: String? = null,
    val state: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null
)

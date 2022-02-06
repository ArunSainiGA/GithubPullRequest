package com.example.gitpullrequest.data.mapper

import com.example.gitpullrequest.data.response.PullRequestResponse
import com.example.gitpullrequest.ui.main.PullRequest
import com.example.gitpullrequest.ui.main.State
import com.example.gitpullrequest.utils.fromISOToSystem
import javax.inject.Inject

class PullRequestMapper @Inject constructor() {

    fun map(pullRequestResponses: List<PullRequestResponse>): List<PullRequest> {
        return pullRequestResponses.map {
            map(it)
        }
    }

    fun map(pullRequestResponse: PullRequestResponse): PullRequest {
        return PullRequest(
            pullRequestResponse.number ?: 0,
            pullRequestResponse.title ?: "",
            pullRequestResponse.body ?: "",
            if(pullRequestResponse.state == "open") State.OPEN else State.CLOSED,
            pullRequestResponse.created_at?.let { fromISOToSystem(it) } ?: "",
            pullRequestResponse.updated_at?.let { fromISOToSystem(it) } ?: ""
        )
    }
}
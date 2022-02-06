package com.example.gitpullrequest.domain.repository

import com.example.gitpullrequest.ui.main.PullRequest

interface PullRequestRepository {
    suspend fun getPullRequests(): List<PullRequest>
}
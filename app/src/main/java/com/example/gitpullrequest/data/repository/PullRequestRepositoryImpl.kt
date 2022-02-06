package com.example.gitpullrequest.data.repository

import com.example.gitpullrequest.data.mapper.PullRequestMapper
import com.example.gitpullrequest.data.service.PullRequestService
import com.example.gitpullrequest.domain.repository.PullRequestRepository
import com.example.gitpullrequest.ui.main.PullRequest
import javax.inject.Inject

class PullRequestRepositoryImpl @Inject constructor(
    private val service: PullRequestService,
    private val mapper: PullRequestMapper
): PullRequestRepository {
    override suspend fun getPullRequests(): List<PullRequest> {
        return mapper.map(service.getPullRequest())
    }
}
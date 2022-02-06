package com.example.gitpullrequest.domain.usecase

import com.example.gitpullrequest.domain.repository.PullRequestRepository
import com.example.gitpullrequest.ui.main.PullRequest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PullRequestUseCase @Inject constructor(private val repository: PullRequestRepository) {
    suspend fun fetchPullRequests() = flow<Result<List<PullRequest>>>{
        try {
            emit(Result.success(repository.getPullRequests()))
        } catch (ex: Exception) {
            emit(Result.failure(ex))
        }
    }
}
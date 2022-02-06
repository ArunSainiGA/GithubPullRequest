package com.example.gitpullrequest.data.service

import com.example.gitpullrequest.data.response.PullRequestResponse
import retrofit2.http.GET

interface PullRequestService {
    @GET("repos/octocat/hello-world/pulls")
    suspend fun getPullRequest(): List<PullRequestResponse>
}
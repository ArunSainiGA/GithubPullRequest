package com.example.gitpullrequest.ui

import com.example.gitpullrequest.data.repository.PullRequestRepositoryImpl
import com.example.gitpullrequest.domain.repository.PullRequestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PullRequestModule {
    @Binds
    abstract fun bindPullRequestRepo(repositoryImpl: PullRequestRepositoryImpl): PullRequestRepository
}
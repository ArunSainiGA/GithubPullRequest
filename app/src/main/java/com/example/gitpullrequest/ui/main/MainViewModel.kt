package com.example.gitpullrequest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitpullrequest.domain.usecase.PullRequestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: PullRequestUseCase
): ViewModel() {
    private val _pullRequests = MutableLiveData<List<PullRequest>>()
    val pullRequests: LiveData<List<PullRequest>> = _pullRequests

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun fetchPullRequest() {
        viewModelScope.launch {
            _loading.postValue(true)
            useCase.fetchPullRequests().collect {
                if(it.isSuccess) {
                    _loading.postValue(false)
                    _pullRequests.postValue(it.getOrNull())
                } else {
                    _loading.postValue(false)
                    _error.postValue(it.exceptionOrNull()?.message)
                }
            }
        }
    }
}
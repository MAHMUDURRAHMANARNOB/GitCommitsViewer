package com.mahmudur.gitcommitviewer.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mahmudur.gitcommitviewer.data.GitHubRepository
import com.mahmudur.gitcommitviewer.paging.CommitsPagingSource

class CommitViewModel: ViewModel() {
    private val repository = GitHubRepository()

    //PagingConfig
    private val pageSize = 20
    private val config = PagingConfig(pageSize = pageSize, enablePlaceholders = false)

    // Flow for fetching commits
    val commitFlow = Pager(config) {
        CommitsPagingSource(repository,pageSize)
    }.flow.cachedIn(viewModelScope)
}
package com.mahmudur.gitcommitviewer.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mahmudur.gitcommitviewer.data.GitHubRepository
import com.mahmudur.gitcommitviewer.model.dataModel
import com.mahmudur.gitcommitviewer.ui.Commits

class CommitsPagingSource(
    private val repository: GitHubRepository,
    private val pageSize: Int )
    : PagingSource<Int, dataModel.Commit>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, dataModel.Commit> {
        return try {
            val pageNumber = params.key ?: 1
            val commits = repository.getCommits(pageNumber, pageSize)
            val prevKey = if (pageNumber > 1) pageNumber - 1 else null
            val nextKey = if (commits.isNotEmpty()) pageNumber + 1 else null

            LoadResult.Page(commits, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, dataModel.Commit>): Int? {
        return null
    }
}
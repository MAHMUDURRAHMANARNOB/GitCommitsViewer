package com.mahmudur.gitcommitviewer.data

import com.mahmudur.gitcommitviewer.model.dataModel
import com.mahmudur.gitcommitviewer.network.GitHubService
import com.mahmudur.gitcommitviewer.ui.Commits
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(GitHubService::class.java)

    suspend fun getCommits(page: Int, perPage: Int): List<dataModel.Commit> {
        return service.getCommits(page, perPage)
    }
}
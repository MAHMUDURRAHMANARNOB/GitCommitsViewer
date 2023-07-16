package com.mahmudur.gitcommitviewer.network

import com.mahmudur.gitcommitviewer.model.dataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("repos/cocogitto/cocogitto/commits")
    suspend fun getCommits(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<dataModel.Commit>
}
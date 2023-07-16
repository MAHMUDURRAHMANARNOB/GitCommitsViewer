package com.mahmudur.gitcommitviewer.model

class dataModel {
    data class Commit(
        val sha: String,
        val message: String,
        val committer: Committer
    )

    data class Committer(
        val login: String,
        val avatarUrl: String
    )
}
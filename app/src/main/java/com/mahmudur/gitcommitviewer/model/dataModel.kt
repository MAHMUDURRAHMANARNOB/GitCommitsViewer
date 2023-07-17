package com.mahmudur.gitcommitviewer.model

class dataModel {
    data class Commit(
        val sha: String,
        val message: String,
        val committer: Committer,
        val author: Author
    )

    data class Committer(
        val login: String,
        val avatar_url: String

    )
    data class Author(
        val name: String,
        val avatar_url: String

    )
}
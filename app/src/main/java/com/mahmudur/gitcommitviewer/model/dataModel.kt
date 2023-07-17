package com.mahmudur.gitcommitviewer.model

class dataModel {
    data class Commit(
        val sha : String,
        val commit: CommitMessage,
        val committer: Committer,

    )

    data class CommitMessage(
        val message: String,
        /*val author: Author*/
        /*val committer: CommitterName*/

    )

    data class Committer(
        val login: String,
        val avatar_url: String

    )

    /*data class CommitterName(
        val name: String,
        val email: String

    )*/

    /*data class Author(
        val name: String,
        val avatar_url: String

    )*/
}
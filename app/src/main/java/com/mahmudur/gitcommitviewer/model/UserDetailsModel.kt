package com.mahmudur.gitcommitviewer.model

class UserDetailsModel {

    data class User(
        val name : String,
        val login : String,
        val avatar_url : String,
        val bio : String,
        val public_repos : String,
        val public_gists : String,
        /*val commit: dataModel.CommitMessage,
        val committer: dataModel.Committer,*/

        )

}
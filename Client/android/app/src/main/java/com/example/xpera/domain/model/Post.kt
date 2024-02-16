package com.example.xpera.domain.model

data class Post(
    val id:Int,
    val userName:String,
    val userProfileImageUrl:String?=null,
    val date:String,
    val title:String,
    val content:String,
    val tags:List<String>
)

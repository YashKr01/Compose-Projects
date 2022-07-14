package com.example.composeplayground.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TeamMember(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)
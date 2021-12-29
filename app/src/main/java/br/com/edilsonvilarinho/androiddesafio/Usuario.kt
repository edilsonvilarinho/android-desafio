package br.com.edilsonvilarinho.androiddesafio

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
)

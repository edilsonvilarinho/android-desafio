package br.com.edilsonvilarinho.androiddesafio.data.model

import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.UserEntity
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
)

fun User.toUserEntity() = UserEntity(
    id = id,
    name = name,
    imageUrl = img,
    username = username
)
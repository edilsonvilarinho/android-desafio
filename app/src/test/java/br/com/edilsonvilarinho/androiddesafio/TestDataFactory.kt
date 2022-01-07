package br.com.edilsonvilarinho.androiddesafio

import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.UserEntity
import br.com.edilsonvilarinho.androiddesafio.data.model.User

class TestDataFactory {
    fun userEntityList() = listOf(
        UserEntity(
            id = 1,
            name = "name1",
            username = "username1",
            imageUrl = "url"
        ),
        UserEntity(
            id = 2,
            name = "name2",
            username = "username2",
            imageUrl = "url"
        ),
        UserEntity(
            id = 3,
            name = "name3",
            username = "username3",
            imageUrl = "url"
        )
    )

    fun userList() = listOf(
        User(
            id = 1,
            name = "name1",
            username = "username1",
            img = "url"
        ),
        User(
            id = 2,
            name = "name2",
            username = "username2",
            img = "url"
        ),
        User(
            id = 3,
            name = "name3",
            username = "username3",
            img = "url"
        )
    )
}
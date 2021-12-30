package br.com.edilsonvilarinho.androiddesafio.data.local.db

class DataBaseConstants private constructor() {
    object USER {
        const val TABLE_NAME = "User"

        object COLLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val USERNAME = "username"
            const val IMG = "img"
        }
    }

}
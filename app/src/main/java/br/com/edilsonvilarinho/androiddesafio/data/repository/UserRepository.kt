package br.com.edilsonvilarinho.androiddesafio.data.repository

import br.com.edilsonvilarinho.androiddesafio.data.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>?
    suspend fun getLocalUsers(): List<User>?
}
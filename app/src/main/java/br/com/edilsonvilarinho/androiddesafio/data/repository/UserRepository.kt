package br.com.edilsonvilarinho.androiddesafio.data.repository

import br.com.edilsonvilarinho.androiddesafio.data.model.User

interface UserRepository {
    fun getUsers(): List<User>
}
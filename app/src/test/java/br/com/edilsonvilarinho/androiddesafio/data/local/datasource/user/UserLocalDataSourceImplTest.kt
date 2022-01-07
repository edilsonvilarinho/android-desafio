package br.com.edilsonvilarinho.androiddesafio.data.local.datasource.user

import br.com.edilsonvilarinho.androiddesafio.TestDataFactory
import br.com.edilsonvilarinho.androiddesafio.data.model.toUserEntity
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test


@ExperimentalCoroutinesApi
class UserLocalDataSourceImplTest {

    @Test
    fun `when insertUsers is called, correct dao method is called`() = runBlockingTest {
    }

    @Test
    fun testInsertUsers() {
    }
}
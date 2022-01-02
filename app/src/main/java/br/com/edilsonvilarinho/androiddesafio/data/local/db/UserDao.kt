package br.com.edilsonvilarinho.androiddesafio.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun getUsers(): List<UserEntity>

}
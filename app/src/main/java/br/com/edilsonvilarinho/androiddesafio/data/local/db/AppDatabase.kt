package br.com.edilsonvilarinho.androiddesafio.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.edilsonvilarinho.androiddesafio.data.local.db.entity.UserEntity

@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun createDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "android-desafio.db")
                .build()

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = createDatabase(context)
                INSTANCE = instance

                instance
            }
        }
    }
}
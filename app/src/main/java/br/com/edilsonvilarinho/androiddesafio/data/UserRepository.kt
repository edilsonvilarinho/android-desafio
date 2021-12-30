package br.com.edilsonvilarinho.androiddesafio.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import br.com.edilsonvilarinho.androiddesafio.domain.User

class UserRepository private constructor(context: Context) {

    private var mUserDataBaseHelper: UserDataBaseHelper = UserDataBaseHelper(context)

    companion object {
        private lateinit var respository: UserRepository
        fun getInstance(context: Context): UserRepository {
            if (!Companion::respository.isInitialized) {
                respository = UserRepository(context)
            }
            return respository
        }

    }

    fun save(user: User): Boolean {
        try {
            val db = mUserDataBaseHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.USER.COLLUMNS.ID, user.id)
            contentValues.put(DataBaseConstants.USER.COLLUMNS.NAME, user.name)
            contentValues.put(DataBaseConstants.USER.COLLUMNS.USERNAME, user.username)
            contentValues.put(DataBaseConstants.USER.COLLUMNS.IMG, user.img)
            db.insert(DataBaseConstants.USER.TABLE_NAME, null, contentValues)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun update(user: User): Boolean {
        try {
            val db = mUserDataBaseHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.USER.COLLUMNS.ID, user.id)
            contentValues.put(DataBaseConstants.USER.COLLUMNS.NAME, user.name)
            contentValues.put(DataBaseConstants.USER.COLLUMNS.USERNAME, user.username)
            contentValues.put(DataBaseConstants.USER.COLLUMNS.IMG, user.img)
            val selection = DataBaseConstants.USER.COLLUMNS.ID + " = ?"
            val args = arrayOf(user.id.toString())
            db.update(DataBaseConstants.USER.TABLE_NAME, contentValues, selection, args)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun delete(id: Int): Boolean {
        try {
            val db = mUserDataBaseHelper.writableDatabase
            val selection = DataBaseConstants.USER.COLLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())
            db.delete(DataBaseConstants.USER.TABLE_NAME, selection, args)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    @SuppressLint("Range")
    fun get(id: Int): User? {
        var user: User? = null
        try {
            val db = mUserDataBaseHelper.readableDatabase
            val projection = arrayOf(
                DataBaseConstants.USER.COLLUMNS.ID,
                DataBaseConstants.USER.COLLUMNS.NAME,
                DataBaseConstants.USER.COLLUMNS.USERNAME,
                DataBaseConstants.USER.COLLUMNS.IMG
            )
            val selection = DataBaseConstants.USER.COLLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())
            var cursor: Cursor = db.query(
                DataBaseConstants.USER.TABLE_NAME,
                projection,
                selection,
                args,
                null,
                null,
                null
            )

            if (cursor.count > 0) {
                cursor.moveToFirst()
                var idValue =
                    cursor.getInt(cursor.getColumnIndex(DataBaseConstants.USER.COLLUMNS.ID))
                var name =
                    cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLLUMNS.NAME))
                var username =
                    cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLLUMNS.USERNAME))
                var img =
                    cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLLUMNS.IMG))
                user = User(img, name, idValue, username)
            }
        } catch (e: Exception) {
        }
        return user
    }

    @SuppressLint("Range")
    fun getAll(): List<User>? {
        val list: MutableList<User> = ArrayList()
        try {
            val db = mUserDataBaseHelper.readableDatabase
            val projection = arrayOf(
                DataBaseConstants.USER.COLLUMNS.ID,
                DataBaseConstants.USER.COLLUMNS.NAME,
                DataBaseConstants.USER.COLLUMNS.USERNAME,
                DataBaseConstants.USER.COLLUMNS.IMG
            )
            var cursor: Cursor = db.query(
                DataBaseConstants.USER.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
            )

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    var idValue =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.USER.COLLUMNS.ID))
                    var name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLLUMNS.NAME))
                    var username =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLLUMNS.USERNAME))
                    var img =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.USER.COLLUMNS.IMG))
                    var user = User(img, name, idValue, username)
                    list.add(user)
                }
            }
        } catch (e: Exception) {
            e.message?.let { Log.e("getAll", it) }
        }
        return list
    }
}
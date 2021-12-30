package br.com.edilsonvilarinho.androiddesafio.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.com.edilsonvilarinho.androiddesafio.data.local.db.DataBaseConstants

class UserDataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_TABLE_USER)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "AndroidDesafio.db"
        private const val CREATE_TABLE_USER = ("CREATE TABLE "
                + DataBaseConstants.USER.TABLE_NAME + "("
                + DataBaseConstants.USER.COLLUMNS.ID + " INTEGER PRIMARY KEY, "
                + DataBaseConstants.USER.COLLUMNS.NAME + " TEXT, "
                + DataBaseConstants.USER.COLLUMNS.USERNAME + " TEXT, "
                + DataBaseConstants.USER.COLLUMNS.IMG + " TEXT);")
    }
}
package com.example.iceapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "ice_app.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_STUDENTS = "students"
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_NUMBER = "number"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val create = """
            CREATE TABLE $TABLE_STUDENTS (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_NAME TEXT NOT NULL,
                $COL_NUMBER TEXT NOT NULL
            )
        """.trimIndent()
        db.execSQL(create)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
        onCreate(db)
    }

    fun insertStudent(name: String, number: String): Long {
        val db = writableDatabase
        val cv = ContentValues().apply {
            put(COL_NAME, name)
            put(COL_NUMBER, number)
        }
        return db.insert(TABLE_STUDENTS, null, cv)
    }

    fun getAllStudents(): List<Student> {
        val list = mutableListOf<Student>()
        val db = readableDatabase
        val cursor = db.query(TABLE_STUDENTS, arrayOf(COL_ID, COL_NAME, COL_NUMBER), null, null, null, null, "$COL_ID DESC")
        cursor.use {
            while (it.moveToNext()) {
                val id = it.getLong(it.getColumnIndexOrThrow(COL_ID))
                val name = it.getString(it.getColumnIndexOrThrow(COL_NAME))
                val number = it.getString(it.getColumnIndexOrThrow(COL_NUMBER))
                list.add(Student(id, name, number))
            }
        }
        return list
    }
}

package com.polishnet.displayusername.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [UsernameEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun usernameDao(): UsernameDao
}
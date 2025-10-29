package com.polishnet.displayusername.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "username")
data class UsernameEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
   @ColumnInfo(name = "myUsername") val myUsername: String
)

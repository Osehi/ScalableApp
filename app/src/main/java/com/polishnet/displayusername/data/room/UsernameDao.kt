package com.polishnet.displayusername.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UsernameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyUsername(myUsername: UsernameEntity)

    @Query("SELECT * FROM username ORDER BY id DESC LIMIT 1")
    fun getSavedUsername(): Flow<UsernameEntity>
}
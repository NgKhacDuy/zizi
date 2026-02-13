package com.khacduy.zizi_room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Upsert

@Dao
interface BaseDao<T> {

    @Upsert()
    fun insertOrUpdate(value: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(value: T)

    @Delete
    fun delete(value: T)
}
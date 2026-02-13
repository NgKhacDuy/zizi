package com.khacduy.zizi_room.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

abstract class BaseEntity {
  @PrimaryKey var id: String = UUID.randomUUID().toString()

  @ColumnInfo(name = "created_at") var createdAt: Long = System.currentTimeMillis()

  @ColumnInfo(name = "updated_at") var updatedAt: Long? = null

  @ColumnInfo(name = "deleted_at") var deletedAt: Long? = null
}

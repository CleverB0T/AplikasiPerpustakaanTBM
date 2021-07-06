package com.learn.android.aplikasiperpustakaantbm.data.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserEntity(

    var nameAdmin: String? = null,
    var username: String? = null,
    var password: String? = null,
    var imageUser: Bitmap? = null,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

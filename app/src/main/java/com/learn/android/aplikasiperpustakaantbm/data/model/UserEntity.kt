package com.learn.android.aplikasiperpustakaantbm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id_admin")
    var idAdmin: Int,

    @ColumnInfo(name = "name_admin")
    var nameAdmin: String,

    var username: String,

    var password: String,

    @ColumnInfo(name = "id_pengunjung")
    var idPengunjung: String
)

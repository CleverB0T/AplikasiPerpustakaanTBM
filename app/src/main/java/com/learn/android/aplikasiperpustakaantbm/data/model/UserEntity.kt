package com.learn.android.aplikasiperpustakaantbm.data.model

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users_table")
data class UserEntity(

    var nameAdmin: String? = null,
    var username: String? = null,
    var password: String? = null,
    var imageUser: Bitmap? = null,

) : Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

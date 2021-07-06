package com.learn.android.aplikasiperpustakaantbm.data.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class BookEntity(

    var noBuku: String? = null,
    var namaBuku: String? = null,
    var kategory: String? = null,
    var genre: String? = null,
    var jumlahBuku: Int = 0,
    var deskripsiBuku: String,
    var imageBook: Bitmap? = null,
    var timestamp: Long = 0L,
    var favorite: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

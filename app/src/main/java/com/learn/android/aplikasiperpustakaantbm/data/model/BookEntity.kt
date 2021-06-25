package com.learn.android.aplikasiperpustakaantbm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class BookEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "no_buku")
    var noBuku: String,

    @ColumnInfo(name = "nama_buku")
    var namaBuku: String,

    var kategory: String,

    var genre: String,

    @ColumnInfo(name = "jumlah_buku")
    var jumlahBuku: Int,

    @ColumnInfo(name = "deskripsi_buku")
    var deskripsiBuku: String
)

package com.learn.android.aplikasiperpustakaantbm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "pengunjung_table")
data class PengunjungEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id_pengunjung")
    var idPengunjung: String,

    @ColumnInfo(name = "nama_pengunjung")
    var namaPengunjung: String,

    @ColumnInfo(name = "tanggal_peminjaman")
    var tanggalPeminjaman: Date,

    @ColumnInfo(name = "tanggal_pengembalian")
    var tanggalPengembalian: Date,

    @ColumnInfo(name = "no_buku")
    var noBuku: String,


)

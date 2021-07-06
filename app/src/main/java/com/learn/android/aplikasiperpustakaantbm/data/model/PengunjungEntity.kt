package com.learn.android.aplikasiperpustakaantbm.data.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "pengunjung_table")
data class PengunjungEntity(

    var idPengunjung: String? = null,
    var namaPengunjung: String? = null,
    var tanggalPeminjaman: Long? = 0,
    var tanggalPengembalian: Long? = 0,
    var noBuku: String? = null,
    var photoIdentity: Bitmap? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

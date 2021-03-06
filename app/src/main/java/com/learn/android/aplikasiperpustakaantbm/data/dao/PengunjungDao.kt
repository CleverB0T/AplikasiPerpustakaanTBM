package com.learn.android.aplikasiperpustakaantbm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.learn.android.aplikasiperpustakaantbm.data.model.PengunjungEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PengunjungDao {

    @Insert
    suspend fun insert(pengunjungEntity: PengunjungEntity)

    @Query("SELECT * FROM pengunjung_table")
    fun getAllPengunjung(): Flow<List<PengunjungEntity>>

    @Query("SELECT SUM(id) FROM pengunjung_table")
    fun getTotalPengunjung(): Flow<Int>
}
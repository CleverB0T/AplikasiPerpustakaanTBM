package com.learn.android.aplikasiperpustakaantbm.data.repository

import com.learn.android.aplikasiperpustakaantbm.data.dao.PengunjungDao
import com.learn.android.aplikasiperpustakaantbm.data.model.PengunjungEntity
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PengunjungRepository @Inject constructor(
    val pengunjungDao: PengunjungDao
) {

    suspend fun insertPengunjung(pengunjungEntity: PengunjungEntity) =
        pengunjungDao.insert(pengunjungEntity)

    fun getAllPengunjung() = pengunjungDao.getAllPengunjung()

    fun getTotal() = pengunjungDao.getTotalPengunjung()
}
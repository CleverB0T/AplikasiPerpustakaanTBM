package com.learn.android.aplikasiperpustakaantbm.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class AdminAndPengunjung(
    @Embedded val userEntity: UserEntity
)

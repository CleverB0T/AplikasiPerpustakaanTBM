package com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.learn.android.aplikasiperpustakaantbm.data.repository.PengunjungRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PengunjungViewModel @Inject constructor(
    val pengunjungRepository: PengunjungRepository
) : ViewModel() {

}
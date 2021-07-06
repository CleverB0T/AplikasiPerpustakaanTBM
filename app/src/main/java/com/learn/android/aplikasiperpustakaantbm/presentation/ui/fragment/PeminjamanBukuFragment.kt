package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.LocaleListCompat
import androidx.fragment.app.Fragment
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentPeminjamanBukuBinding
import java.text.SimpleDateFormat
import java.util.*


class PeminjamanBukuFragment : Fragment() {

    private lateinit var bindingFrgament: FragmentPeminjamanBukuBinding
    private val cal = Calendar.getInstance()
    private val myYear = cal.get(Calendar.YEAR)
    private val myMonth = cal.get(Calendar.MONTH)
    private val day = cal.get(Calendar.DAY_OF_MONTH)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingFrgament = FragmentPeminjamanBukuBinding.inflate(inflater, container, false)
        return bindingFrgament.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingFrgament.editTextTglPeminjaman.setOnClickListener {
            val datePickerDialog = DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->
                val myFormat = "dd.MM.yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
                bindingFrgament.editTextTglPeminjaman.setText(sdf.format(cal.time))
            }, myYear, myMonth, day)
            datePickerDialog.show()
        }
    }

}
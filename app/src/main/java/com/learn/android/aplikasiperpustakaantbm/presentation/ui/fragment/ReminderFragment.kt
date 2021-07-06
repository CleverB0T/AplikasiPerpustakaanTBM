package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentReminderBinding


class ReminderFragment : Fragment() {

    private lateinit var bindingFragment: FragmentReminderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFragment = FragmentReminderBinding.inflate(inflater, container, false)
        return bindingFragment.root
    }

}
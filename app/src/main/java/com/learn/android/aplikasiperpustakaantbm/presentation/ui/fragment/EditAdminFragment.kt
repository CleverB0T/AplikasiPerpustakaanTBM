package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentEditAdminBinding


class EditAdminFragment : Fragment() {

    private lateinit var bindingFragment: FragmentEditAdminBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFragment = FragmentEditAdminBinding.inflate(inflater, container, false)

        bindingFragment.buttonBackProfile.setOnClickListener {
            it.findNavController().navigate(R.id.action_editAdminFragment_to_userFragment)
        }
        return inflater.inflate(R.layout.fragment_edit_admin, container, false)
    }

}
package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    private lateinit var bindingFragment: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFragment = FragmentAboutBinding.inflate(inflater, container, false)

        bindingFragment.buttonBackAbout.setOnClickListener {
            it.findNavController().navigate(R.id.action_aboutFragment_to_userFragment)
        }

        return bindingFragment.root

    }

}
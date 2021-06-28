package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var bindingFragment: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFragment = FragmentSplashBinding.inflate(inflater, container, false)

        bindingFragment.buttonLog.setOnClickListener {
            it.findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }

        return bindingFragment.root

    }

}
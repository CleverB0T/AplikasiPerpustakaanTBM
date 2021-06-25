package com.learn.android.aplikasiperpustakaantbm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var bindingFragment: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFragment = FragmentHomeBinding.inflate(inflater, container, false)

        bindingFragment.buttonUser.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_userFragment)
        }
        return bindingFragment.root
    }
}
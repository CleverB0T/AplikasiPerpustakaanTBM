package com.learn.android.aplikasiperpustakaantbm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentUserBinding


class UserFragment : Fragment() {


    private lateinit var bindingFragment: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFragment = FragmentUserBinding.inflate(inflater, container, false)

        bindingFragment.buttonBackProfile.setOnClickListener {
            it.findNavController().navigate(R.id.action_userFragment_to_homeFragment)
        }

        bindingFragment.buttonAddAdmin.setOnClickListener {
            it.findNavController().navigate(R.id.action_userFragment_to_addAdminFragment)
        }

        return bindingFragment.root
    }

}
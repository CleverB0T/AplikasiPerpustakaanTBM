package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentHomeBinding
import com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var bindingFragment: FragmentHomeBinding
    private val viewModel: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingFragment = FragmentHomeBinding.inflate(inflater, container, false)

        bindingFragment.buttonUser.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_userFragment)
        }

        bindingFragment.buttonAddBook.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_addBookFragment)
        }
        return bindingFragment.root
    }
}
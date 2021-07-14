package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentHomeBinding
import com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var bindingFragment: FragmentHomeBinding
    private val args: HomeFragmentArgs by navArgs()
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        bindingFragment.myViewModel = viewModel
        bindingFragment.lifecycleOwner = this

        args.user?.imageUser?.let { viewModel.getUser(it) }

        viewModel.userImage.observe(viewLifecycleOwner, {
            bindingFragment.buttonUser.setImageBitmap(it)
        })

        bindingFragment.buttonUser.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_userFragment)
        }

        bindingFragment.buttonAddBook.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_addBookFragment)
        }
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
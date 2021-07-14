package com.learn.android.aplikasiperpustakaantbm.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.learn.android.aplikasiperpustakaantbm.R
import com.learn.android.aplikasiperpustakaantbm.data.model.UserEntity
import com.learn.android.aplikasiperpustakaantbm.data.utils.EventObserver
import com.learn.android.aplikasiperpustakaantbm.databinding.FragmentLoginBinding
import com.learn.android.aplikasiperpustakaantbm.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var bindingFragment: FragmentLoginBinding
    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        bindingFragment.myViewModel = viewModel
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.message.observe(viewLifecycleOwner, {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        })

        bindingFragment.lifecycleOwner = this.viewLifecycleOwner
        setupNavigation()
    }

    private fun setupNavigation() {
        viewModel.loginEvent.observe(viewLifecycleOwner, EventObserver {
            directHomeFragment(it)
        })
    }

    private fun directHomeFragment(user: UserEntity) {
        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(user)
        findNavController().navigate(action)
    }

}
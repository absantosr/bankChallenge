package com.santos.bankchallengue.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.santos.bankchallengue.R
import com.santos.bankchallengue.databinding.FragmentLoginBinding
import com.santos.bankchallengue.presentation.util.LoginState
import com.santos.bankchallengue.presentation.util.getViewModel
import com.santos.bankchallengue.presentation.util.setSafeOnClickListener

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel {
            LoginViewModel()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btEntry.setSafeOnClickListener {
            val userName = binding.etUser.text.toString()
            val pass = binding.etPass.text.toString()
            viewModel.login(userName, pass)
        }

        viewModel.userAuthLiveData.observe(
            viewLifecycleOwner,
            Observer { userAuthenticationState(it) })
    }

    private fun userAuthenticationState(state: LoginState) {
        when (state) {
            is LoginState.Loading -> {

            }
            is LoginState.Error -> {

            }
            is LoginState.Success -> {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToTaskFragment(state.uid)
                )
            }
        }
    }

}
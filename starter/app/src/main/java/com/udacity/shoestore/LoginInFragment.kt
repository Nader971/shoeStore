package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginInBinding


class LoginInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginInBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login_in, container, false)

        binding.btnSignIn.setOnClickListener{ view: View ->
            Navigation.findNavController(view).navigate(R.id.action_loginInFragment_to_welcomeScreenFragment)
        }
        binding.btnCreate.setOnClickListener{ view: View ->
            Navigation.findNavController(view).navigate(R.id.action_loginInFragment_to_welcomeScreenFragment)
        }

        return binding.root

    }

}
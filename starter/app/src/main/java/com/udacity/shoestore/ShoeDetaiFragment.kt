package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetaiBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoe_list.ShoeListViewModel


class ShoeDetaiFragment : Fragment() {

    private val shoeDataiViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetaiBinding =DataBindingUtil.inflate( inflater,
            R.layout.fragment_shoe_detai, container, false)
        binding.shoeListViewModel = shoeDataiViewModel
        binding.shoe = Shoe()

        binding.saveButton.setOnClickListener { view: View ->
            shoeDataiViewModel.addShoes(shoeDataiViewModel.shoe)
           view.findNavController().navigate(ShoeDetaiFragmentDirections.actionShoeDetaiFragmentToShoeListScreenFragment())
        }

        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeDetaiFragmentDirections.actionShoeDetaiFragmentToShoeListScreenFragment())
        }
        return binding.root
    }

}
package com.udacity.shoestore.shoe_list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListScreenBinding
import com.udacity.shoestore.models.Shoe


class ShoeListScreenFragment : Fragment() {


    private val shoeListViewModel:ShoeListViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeListScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list_screen, container, false
        )

        shoeListViewModel.getShoeLiveData().observe(viewLifecycleOwner) {
            if(it.isNotEmpty()) {
                addShoes(it)
            }
        }

        binding.fabAddNewShoe.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeListScreenFragmentDirections.actionShoeListScreenFragmentToShoeDetaiFragment())

        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun addShoes(shoes: List<Shoe>) {
       context?.let { context ->
           val listScreen = binding.ownerLinear
           shoes.forEach{ shoe->
               val itemLayout = ItemLayout(context)
               itemLayout.setUpItem(shoe)
               listScreen.addView(itemLayout)
           }
       }
    }





}
package com.example.desafiopicpay.screens.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.desafiopicpay.R
import com.example.desafiopicpay.databinding.FragmentCardBinding

class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCardBinding.inflate(inflater, container, false)

        binding.registerCardBtn.setOnClickListener{
            findNavController().navigate(CardFragmentDirections.actionCardFragmentToCardRegisterFragment())
        }


        return binding.root
    }

}
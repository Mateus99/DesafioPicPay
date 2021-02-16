package com.example.desafiopicpay.screens.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafiopicpay.R
import com.example.desafiopicpay.databinding.FragmentCardRegisterBinding

class CardRegisterFragment : Fragment() {

    private lateinit var binding: FragmentCardRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentCardRegisterBinding.inflate(inflater, container, false)


        return binding.root
    }

}
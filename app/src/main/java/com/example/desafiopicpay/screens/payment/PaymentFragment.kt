package com.example.desafiopicpay.screens.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafiopicpay.R
import com.example.desafiopicpay.databinding.FragmentPaymentBinding


class PaymentFragment : Fragment() {


    private lateinit var binding: FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentPaymentBinding.inflate(inflater, container, false)

        val args = PaymentFragmentArgs.fromBundle(requireArguments())

        binding.imgUrl = args.userImg

        binding.usernameTxt.text = args.username

        return binding.root
    }

}
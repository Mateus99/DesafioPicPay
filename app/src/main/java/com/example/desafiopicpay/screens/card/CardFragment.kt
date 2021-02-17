package com.example.desafiopicpay.screens.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.desafiopicpay.databinding.FragmentCardBinding
import com.example.desafiopicpay.screens.payment.PaymentFragmentArgs

class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCardBinding.inflate(inflater, container, false)
        val args = PaymentFragmentArgs.fromBundle(requireArguments())

        binding.registerCardBtn.setOnClickListener {
            findNavController().navigate(
                CardFragmentDirections.actionCardFragmentToCardRegisterFragment(
                    args.username,
                    args.userImg
                )
            )
        }


        return binding.root
    }

}
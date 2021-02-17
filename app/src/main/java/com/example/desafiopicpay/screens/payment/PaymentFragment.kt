package com.example.desafiopicpay.screens.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.desafiopicpay.databinding.FragmentPaymentBinding


class PaymentFragment : Fragment() {


    private val viewModel: PaymentViewModel by lazy {
        ViewModelProvider(this).get(PaymentViewModel::class.java)
    }

    private lateinit var binding: FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaymentBinding.inflate(inflater, container, false)
        val args = PaymentFragmentArgs.fromBundle(requireArguments())

        binding.viewModel = viewModel

        binding.imgUrl = args.userImg
        binding.usernameTxt.text = args.username

        binding.editCard.setOnClickListener {
            findNavController().navigate(
                PaymentFragmentDirections.actionPaymentFragmentToCardRegisterFragment(
                    args.username,
                    args.userImg
                )
            )
        }

        binding.payBtn.setOnClickListener {
            viewModel.makePayment()
        }


        return binding.root
    }


}
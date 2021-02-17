package com.example.desafiopicpay.screens.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.desafiopicpay.databinding.FragmentCardRegisterBinding
import com.example.desafiopicpay.screens.payment.PaymentFragmentArgs

class CardRegisterFragment : Fragment() {


    private lateinit var binding: FragmentCardRegisterBinding

    private val viewModel: CardRegisterViewModel by lazy {
        ViewModelProvider(this).get(CardRegisterViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCardRegisterBinding.inflate(inflater, container, false)
        val args = PaymentFragmentArgs.fromBundle(requireArguments())

        binding.viewModel = viewModel

        viewModel.loadData(
            requireActivity(),
            binding.cardNumber,
            binding.cardName,
            binding.expireDate,
            binding.cvv
        )

        viewModel.checkEdits(
            binding.cardNumber.text.toString(),
            binding.cardName.text.toString(),
            binding.expireDate.text.toString(),
            binding.cvv.text.toString(),
            binding.finishRegister
        )
        binding.cardNumber.addTextChangedListener {
            viewModel.checkEdits(
                binding.cardNumber.text.toString(),
                binding.cardName.text.toString(),
                binding.expireDate.text.toString(),
                binding.cvv.text.toString(),
                binding.finishRegister
            )
        }
        binding.cardName.addTextChangedListener {
            viewModel.checkEdits(
                binding.cardNumber.text.toString(),
                binding.cardName.text.toString(),
                binding.expireDate.text.toString(),
                binding.cvv.text.toString(),
                binding.finishRegister
            )
        }
        binding.expireDate.addTextChangedListener {
            viewModel.checkEdits(
                binding.cardNumber.text.toString(),
                binding.cardName.text.toString(),
                binding.expireDate.text.toString(),
                binding.cvv.text.toString(),
                binding.finishRegister
            )
        }
        binding.cvv.addTextChangedListener {
            viewModel.checkEdits(
                binding.cardNumber.text.toString(),
                binding.cardName.text.toString(),
                binding.expireDate.text.toString(),
                binding.cvv.text.toString(),
                binding.finishRegister
            )
        }

        binding.finishRegister.setOnClickListener {
            viewModel.saveData(
                requireActivity(),
                binding.cardNumber.text.toString(),
                binding.cardName.text.toString(),
                binding.expireDate.text.toString(),
                binding.cvv.text.toString()
            )

            findNavController().navigate(
                CardRegisterFragmentDirections.actionCardRegisterFragmentToPaymentFragment(
                    args.username,
                    args.userImg
                )
            )
        }

        return binding.root
    }

}
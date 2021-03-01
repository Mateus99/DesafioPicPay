package com.example.desafiopicpay.screens.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.desafiopicpay.databinding.FragmentCardRegisterBinding
import com.example.desafiopicpay.screens.payment.PaymentFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardRegisterFragment : Fragment() {

    private val viewModel: CardRegisterViewModel by viewModel()

    private lateinit var binding: FragmentCardRegisterBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCardRegisterBinding.inflate(inflater, container, false)
        val args = PaymentFragmentArgs.fromBundle(requireArguments())

        binding.viewModel = viewModel

        val (cardNumber, cardName, expireDate, cvv) = viewModel.loadData(requireActivity())

        binding.cardNumber.setText(cardNumber)
        binding.cardName.setText(cardName)
        binding.expireDate.setText(expireDate)
        binding.cvv.setText(cvv)

        fillEditTexts()

        binding.cardNumber.addTextChangedListener {
            viewModel.cardNumber = binding.cardNumber.text.toString()
            viewModel.verifyData()
        }

        binding.cardName.addTextChangedListener {
            viewModel.cardName = binding.cardName.text.toString()
            viewModel.verifyData()
        }

        binding.expireDate.addTextChangedListener {
            viewModel.expireDate = binding.expireDate.text.toString()
            viewModel.verifyData()
        }

        binding.cvv.addTextChangedListener {
            viewModel.cvv = binding.cvv.text.toString()
            viewModel.verifyData()
        }

        binding.finishRegister.setOnClickListener {
            viewModel.saveData(requireActivity())

            findNavController().navigate(
                CardRegisterFragmentDirections.actionCardRegisterFragmentToPaymentFragment(
                    args.username,
                    args.userImg
                )
            )
        }



        return binding.root
    }

    fun fillEditTexts(){
        viewModel.cardNumber = binding.cardNumber.text.toString()
        viewModel.cardName = binding.cardName.text.toString()
        viewModel.expireDate = binding.expireDate.text.toString()
        viewModel.cvv = binding.cvv.text.toString()
        viewModel.verifyData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.btnVisibility.observe(viewLifecycleOwner, Observer {
            if (viewModel.btnVisibility.value == true){
                binding.finishRegister.visibility = View.VISIBLE
            } else{
                binding.finishRegister.visibility = View.GONE
            }

        })

    }

}
package com.example.desafiopicpay.screens.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiopicpay.databinding.FragmentPaymentBinding
import com.example.desafiopicpay.screens.users.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class PaymentFragment : Fragment() {


    private val viewModel: PaymentViewModel by viewModel()

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

        //Ver direito pq retrofit não ta funcionando
//        binding.payBtn.setOnClickListener {
//            viewModel.makePayment()
//        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //muito importante, ta passando os dados do properties para o adapter


//        viewModel.transaction.observe(viewLifecycleOwner, Observer {
//            Toast.makeText(requireContext(), "DEU CERTO", Toast.LENGTH_SHORT).show()
//        })

    }


}
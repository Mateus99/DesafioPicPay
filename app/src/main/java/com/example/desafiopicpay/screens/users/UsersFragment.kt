package com.example.desafiopicpay.screens.users

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiopicpay.databinding.FragmentUsersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UsersFragment : Fragment() {

    //Exemplo de utilização sem parametros
    //private val viewModel: UsersViewModel by viewModel()

    //Essa linha faz referencia ao viewModel do Koin
    //Com ela nós substituimos a declaração utilizando o ViewModelProvider comentada abaixo dela
    private val viewModel: UsersViewModel by viewModel()

//    private val viewModel: UsersViewModel by lazy {
//        ViewModelProvider(this).get(UsersViewModel::class.java)
//    }

    private val adapter: UsersAdapter = UsersAdapter { username, img -> mudaTela(username, img) }
    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUsersBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel

        binding.searchEdittext.addTextChangedListener {
            adapter.filter(it.toString())
        }


        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        //muito importante, ta passando os dados do properties para o adapter
        viewModel.properties.observe(viewLifecycleOwner, Observer {
            adapter.setUsuarios(it)
        })

    }

    private fun mudaTela(username: String, img: String) {

        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        val savedCardNumber = sharedPreferences.getString("cardNumber", null)
        val savedCardName = sharedPreferences.getString("cardName", null)
        val savedExpireDate = sharedPreferences.getString("expireDate", null)
        val savedCvv = sharedPreferences.getString("cvv", null)

        if (savedCardNumber != "" && savedCardName != "" && savedExpireDate != "" && savedCvv != "") {
            findNavController().navigate(
                UsersFragmentDirections.actionUsersFragmentToPaymentFragment(
                    username,
                    img
                )
            )
        } else {
            findNavController().navigate(
                UsersFragmentDirections.actionUsersFragmentToCardFragment(
                    username,
                    img
                )
            )
        }


    }


}
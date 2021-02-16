package com.example.desafiopicpay.screens.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiopicpay.R
import com.example.desafiopicpay.databinding.FragmentUsersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UsersFragment : Fragment() {

    //Exemplo de utilização sem parametros
    //private val viewModel: UsersViewModel by viewModel()

    //Essa linha faz referencia ao viewModel do Koin
    //Com ela nós substituimos a declaração utilizando o ViewModelProvider comentada abaixo dela
    private val viewModel: UsersViewModel by viewModel {
        parametersOf(findNavController())
    }

//    private val viewModel: UsersViewModel by lazy {
//        ViewModelProvider(this).get(UsersViewModel::class.java)
//    }

    private val adapter: UsersAdapter = UsersAdapter { username, img -> mudaTela(username, img) }
    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

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

    fun mudaTela(username: String, img: String){
        //Aqui vou ter q fazer uma verificação se já existe algum cartão cadastrado
        findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToCardFragment())
        //findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToPaymentFragment(username, img))
    }


}
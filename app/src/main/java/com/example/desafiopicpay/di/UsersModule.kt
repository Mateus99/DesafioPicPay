package com.example.desafiopicpay.di

import androidx.navigation.NavController
import com.example.desafiopicpay.repository.UsersRepository
import com.example.desafiopicpay.screens.card.CardRegisterViewModel
import com.example.desafiopicpay.screens.payment.PaymentViewModel
import com.example.desafiopicpay.screens.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val usersModule = module {

    //Colocando o NavController como parametro, conseguimos fazer a navegação do app pelo ViewModel
    //Desde que claro, passe o findNavController onde ele é chamado
    viewModel {
        //Toda vez que alquem precisar do UsersViewModel, automaticamente
        //o Koin vai vir aqui no módulo e instanciar pra quem estiver precisando
        UsersViewModel(
            repository = UsersRepository()
        )
    }
    viewModel {
        PaymentViewModel(
            repository = UsersRepository()
        )
    }

    viewModel {
        CardRegisterViewModel()
    }

}
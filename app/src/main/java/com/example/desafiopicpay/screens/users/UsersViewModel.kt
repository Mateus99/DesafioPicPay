package com.example.desafiopicpay.screens.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.desafiopicpay.repository.UsersRepository
import kotlinx.coroutines.launch

class UsersViewModel(private val navController: NavController, val repository: UsersRepository) :
    ViewModel() {

    val properties: LiveData<MutableList<User>>

    init {
        this.properties = repository.properties
        viewModelScope.launch {
            repository.getPicPayUsers()
        }

    }

}
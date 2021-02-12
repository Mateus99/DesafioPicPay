package com.example.desafiopicpay.screens.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopicpay.databinding.ListItemBinding

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {

    var users: MutableList<User> = mutableListOf()

    var usersCopy: MutableList<User> = mutableListOf()

    fun setUsuarios(users: MutableList<User>) {
        this.users = users
        notifyDataSetChanged()

        usersCopy.addAll(users)


    }


    //Responsável por criar cada item da recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.bind(users[position])

    }

    fun filter(text: String) {

        users.clear()
        if (text.isEmpty()) {
            users.addAll(usersCopy)
        } else {
            usersCopy.forEach {
                if (it.name.contains(text)) {
                    users.add(it)
                }
            }
        }

        notifyDataSetChanged()
    }


}
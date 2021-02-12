package com.example.desafiopicpay.screens.users

import androidx.recyclerview.widget.RecyclerView
import com.example.desafiopicpay.databinding.ListItemBinding

class UserViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.nameTextView.text = user.name
        binding.usernameTextView.text = user.username
        binding.profileImg = user.img
    }

}
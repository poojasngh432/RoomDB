package com.example.roomdb

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val users: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = users.size


    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
      holder.bind(users[position])
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(user: User) {
            with(itemView){
                nameTV.text = user.name
                ageTV.text = user.age.toString()
                descTV.text = user.desc
            }
        }

    }
}


package com.example.calculadora.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.R
import com.example.myapplication.model.User

class UserAdapter:RecyclerView.Adapter<UserViewHolder>() {

   private val userDiff =object :DiffUtil.ItemCallback<User>(){
       override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
           return oldItem.id == newItem.id
       }

       override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
           return oldItem== newItem
       }

   }
     val diff=AsyncListDiffer(this,userDiff)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.item_recycler,parent,false))
    }

    override fun getItemCount():Int=diff.currentList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.holderUser(diff.currentList[position])

    }

}
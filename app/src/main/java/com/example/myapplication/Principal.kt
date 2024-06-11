package com.example.myapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculadora.adapter.UserAdapter
import com.example.myapplication.databinding.ActivityPrincipalBinding
import com.example.myapplication.model.Datos
import com.example.myapplication.model.User
import com.example.myapplication.utils.Formatters

class Principal : AppCompatActivity() {
private  lateinit var binding:ActivityPrincipalBinding
    private lateinit var madapter:UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        showList()
        binding.btnAddUser.setOnClickListener{
            addNewUser()
        }

    }

    private fun addNewUser() {
        val dialog =Dialog(this)
        dialog.setContentView(R.layout.dialog_person)
        val nombreT=dialog.findViewById<EditText>(R.id.nameDialog)
        val lastNameT = dialog.findViewById<EditText>(R.id.lastNameDialog)
        val ageT = dialog.findViewById<EditText>(R.id.ageDialog)
        val imageT=dialog.findViewById<EditText>(R.id.imageDialog)
        val add=dialog.findViewById<Button>(R.id.btnSavedInformation)
        add.setOnClickListener {
            val name=nombreT.text.toString()
            val image=imageT.text.toString()
            val lastName= lastNameT.text.toString()
            val age= ageT.text.toString().toInt()
            val user= User(3,image,name, lastName,age,Formatters.getCurrentDate(),Formatters.getCurrentHour())
            Datos.addUser(user)
            madapter.notifyDataSetChanged()
            dialog.dismiss()
        }
        dialog.show()

    }

    private fun showList(){
        madapter.diff.submitList(Datos.lista)
    }
    private fun initRecycler() {
        madapter= UserAdapter()
        binding.recycler.apply {
            layoutManager= LinearLayoutManager(this@Principal)
            adapter=madapter
            setHasFixedSize(true)
        }
    }

}
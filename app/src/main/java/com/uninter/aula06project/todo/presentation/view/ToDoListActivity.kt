package com.uninter.aula06project.todo.presentation.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.aula06project.R
import com.uninter.aula06project.databinding.ActivityToDoListBinding
import com.uninter.aula06project.todo.data.repository.ToDoMemoryRepository
import com.uninter.aula06project.todo.domain.entity.ToDo
import com.uninter.aula06project.todo.presentation.viewmodel.ToDoViewModel

class ToDoListActivity : AppCompatActivity() {

    lateinit var rcToDoList :RecyclerView
    lateinit var binding : ActivityToDoListBinding; //nova forma de manipula o componente do layout
    val viewModel by lazy{
        ViewModelProvider(this).get(ToDoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityToDoListBinding.inflate(layoutInflater)
        var bind = binding.root
        setContentView(bind)


        // rcToDoList = findViewById<RecyclerView>(R.id.rcToDo)
//verificar se tem atualização na lista e instancia o load
        viewModel.todos.observe(this){ //observa as alterações na lista de todos
           // rcToDoList.layoutManager = LinearLayoutManager(this)
           // rcToDoList.adapter = ToDoListAdapter(it)

            binding.rcToDo.layoutManager = LinearLayoutManager(this)
            binding.rcToDo.adapter = ToDoListAdapter(it)

            }
        binding.btnAddTask.setOnClickListener{
            startActivity(Intent(this, ToDoDetailActivity::class.java))

        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.LoadTodo()//atualiza toda vez que entra um nova informação na tela
    }
}
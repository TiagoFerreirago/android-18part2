package com.uninter.aula06project.todo.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.uninter.aula06project.R
import com.uninter.aula06project.todo.domain.entity.ToDo
import com.uninter.aula06project.todo.presentation.viewmodel.ToDoDetailActivityModel


class ToDoDetailActivity : AppCompatActivity() {
    lateinit var edtTitle : EditText
    lateinit var btnComplete : Button
    lateinit var btnRemove : Button
    lateinit var btnAdd : Button

    val viewModel by lazy{
       ViewModelProvider(this).get(ToDoDetailActivityModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_to_do_detail)

        edtTitle = findViewById(R.id.edtTitle)
        btnComplete = findViewById(R.id.btnComplete)
        btnRemove = findViewById(R.id.btnRemove)
        btnAdd = findViewById(R.id.btnAdd)

        var todo = intent.getSerializableExtra("todo") as ToDo?

        if(todo == null){
            btnComplete.visibility = View.GONE
            btnRemove.visibility = View.GONE
            btnAdd.visibility = View.VISIBLE
        }
        else{
            btnComplete.visibility= if(todo.isCompleted)View.GONE else View.VISIBLE
            btnRemove.visibility=View.VISIBLE
            btnAdd.visibility =View.GONE

            edtTitle.setText(todo.title)
            edtTitle.isEnabled = false
        }
        //tudo quee for escrito na caixa de texto, vai preencher o metodo addToDO e retorna na tela
        btnAdd.setOnClickListener() {
            viewModel.addToDo(edtTitle.text.toString())
            Toast.makeText(this, "Aplicação adicionada", Toast.LENGTH_LONG).show()
            finish();
        }
        btnRemove.setOnClickListener(){
            viewModel.removeToDo(edtTitle.text.toString())
            Toast.makeText(this, "Aplicação removida", Toast.LENGTH_LONG).show()
            finish();
        }

        btnComplete.setOnClickListener(){
            todo?.let { the ->
                viewModel.completeToDo(the)
                Toast.makeText(this, "Aplicação Atualizada", Toast.LENGTH_LONG).show()
                finish();
            }
        }
    }
}
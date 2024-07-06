package com.uninter.aula06project.todo.presentation.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uninter.aula06project.R
import com.uninter.aula06project.todo.domain.entity.ToDo

class ToDoListAdapter(val items: List<ToDo>): RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(item: ToDo){
            with(itemView)
            {
                item.let {
                    findViewById<TextView>(R.id.txtToDoTitle).text = it.title
                    if(it.isCompleted)
                        findViewById<ImageView>(R.id.imgIsCompleted).setImageResource(android.R.drawable.checkbox_on_background)
                    else
                        findViewById<ImageView>(R.id.imgIsCompleted).setImageResource(android.R.drawable.checkbox_off_background)

                    findViewById<CardView>(R.id.cardLayout).setOnClickListener(){card ->
                        var intent = Intent(card.context, ToDoDetailActivity::class.java)
                        intent.putExtra("todo",it)
                        card.context.startActivity(intent)//passando o elemento clicado para a proxima tela
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.to_do_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var toDo = items[position]
        holder.bindView(toDo)
    }
}
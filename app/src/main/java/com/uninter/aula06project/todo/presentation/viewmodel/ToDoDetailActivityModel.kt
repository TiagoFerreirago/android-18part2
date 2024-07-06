package com.uninter.aula06project.todo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.uninter.aula06project.todo.domain.entity.ToDo
import com.uninter.aula06project.todo.domain.usecase.ToDoUseCase
import com.uninter.aula06project.todo.domain.usecase.interfaces.IToDoUseCase

class ToDoDetailActivityModel : ViewModel(){
        private val useCase : IToDoUseCase = ToDoUseCase();

        //pegando a lista de toDoo e adicionando um novo item no layout
        fun addToDo(title : String){
                var todo =  (ToDo(title, false));
                useCase.add(todo);//esta inserindo um objeto ToDoo e retornando uma lista na tela
        }

        fun removeToDo(title : String){
                useCase.delete(title);//esta inserindo um objeto ToDoo e retornando uma lista na tela
        }
        fun completeToDo(toDo : ToDo){
                useCase.completeToDo(toDo);//esta inserindo um objeto ToDoo e retornando uma lista na tela
        }
}
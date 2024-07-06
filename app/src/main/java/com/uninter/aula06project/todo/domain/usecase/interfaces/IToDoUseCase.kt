package com.uninter.aula06project.todo.domain.usecase.interfaces

import com.uninter.aula06project.todo.domain.entity.ToDo

interface IToDoUseCase {

    fun add(todo : ToDo)

    fun getAll() : List<ToDo>

    fun delete(title : String)

    fun completeToDo(toDo : ToDo)
}
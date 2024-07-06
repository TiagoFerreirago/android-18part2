package com.uninter.aula06project.todo.data.repository

import com.uninter.aula06project.todo.domain.abstractions.IToDoMemoryRepository
import com.uninter.aula06project.todo.domain.entity.ToDo

object ToDoMemoryRepository : IToDoMemoryRepository {

    private var toDoList = listOf(
        ToDo("Harry Potter", true),
        ToDo("Animais Fantasticos e Onde Habitam", true),
        ToDo("Chapeleiro Maluco", false)
    )

    override fun add(todo: ToDo) {
        toDoList = toDoList.plus(todo);

    }

    override fun getAll(): List<ToDo> {
        return toDoList;
    }

    override fun delete(title: String) {
        toDoList = toDoList.filter { it -> it.title != title }
    }

    override fun completeToDo(toDo: ToDo) {
        for (item in toDoList) {
            if (item.title == toDo.title) {
                item.isCompleted = true

            }
        }
    }
}
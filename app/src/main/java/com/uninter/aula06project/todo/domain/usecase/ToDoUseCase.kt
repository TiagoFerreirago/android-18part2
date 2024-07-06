package com.uninter.aula06project.todo.domain.usecase

import com.uninter.aula06project.todo.data.repository.ToDoMemoryRepository
import com.uninter.aula06project.todo.domain.abstractions.IToDoMemoryRepository
import com.uninter.aula06project.todo.domain.entity.ToDo
import com.uninter.aula06project.todo.domain.usecase.interfaces.IToDoUseCase

class ToDoUseCase : IToDoUseCase{

   private val repository : IToDoMemoryRepository = ToDoMemoryRepository;
    override fun add(todo: ToDo) {
      repository.add(todo);
    }

    override fun getAll(): List<ToDo> {
        return repository.getAll();
    }

    override fun delete(title: String) {
        repository.delete(title);
    }

    override fun completeToDo(toDo: ToDo) {
        repository.completeToDo(toDo);
    }


}
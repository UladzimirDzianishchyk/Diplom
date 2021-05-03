package com.dzianishchyk.diplom.service;


import com.dzianishchyk.diplom.entity.ToDo;
import com.dzianishchyk.diplom.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ToDoService {

    private final ToDoRepository todoRepository;

    public ToDoService(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void newToDo (ToDo todo) {
        todoRepository.save(todo);

    }

    public Optional<ToDo> getToDoById (long id) {
        return todoRepository.findById(id);
    }

    public void deleteToDoById (long id) {
        todoRepository.deleteById(id);
    }


}

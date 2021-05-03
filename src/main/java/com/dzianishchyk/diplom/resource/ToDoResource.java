package com.dzianishchyk.diplom.resource;

import com.dzianishchyk.diplom.entity.ToDo;
import com.dzianishchyk.diplom.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/todo")
public class ToDoResource {

    @Autowired
    private ToDoService toDoService;

    @PostMapping(path = "/create")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo todo) {
        toDoService.newToDo(todo);
        ToDo returnToDo = (toDoService.getToDoById(todo.getId())).get();
        return new ResponseEntity<>(returnToDo, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteToDoById(@PathVariable(name = "id") long id) {
        toDoService.deleteToDoById(id);
        return new ResponseEntity<>("User " + toDoService.getToDoById(id).getClass().getName() + " deleted", HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional> getToDoById(@PathVariable(name = "id") long id) {
        Optional<ToDo> toDo = toDoService.getToDoById(id);
        return new ResponseEntity<>(toDo,HttpStatus.OK);
    }
}

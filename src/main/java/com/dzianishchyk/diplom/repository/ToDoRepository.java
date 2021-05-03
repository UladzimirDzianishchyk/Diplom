package com.dzianishchyk.diplom.repository;

import com.dzianishchyk.diplom.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoRepository extends JpaRepository<ToDo,Long> {
}

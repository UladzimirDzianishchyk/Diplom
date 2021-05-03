package com.dzianishchyk.diplom.repository;


import com.dzianishchyk.diplom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
}

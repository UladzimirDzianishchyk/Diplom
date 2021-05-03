package com.dzianishchyk.diplom.repository;

import com.dzianishchyk.diplom.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

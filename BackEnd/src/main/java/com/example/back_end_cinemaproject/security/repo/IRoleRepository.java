package com.example.back_end_cinemaproject.security.repo;

import com.example.back_end_cinemaproject.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}

package com.example.back_end_cinemaproject.repositories;

import com.example.back_end_cinemaproject.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill, Integer> {
}
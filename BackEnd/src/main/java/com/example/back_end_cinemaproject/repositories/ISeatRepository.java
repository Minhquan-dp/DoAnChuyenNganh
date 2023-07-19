package com.example.back_end_cinemaproject.repositories;

import com.example.back_end_cinemaproject.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> getSeatByRoom_Id(Integer roomId);
}
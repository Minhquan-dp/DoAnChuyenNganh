package com.example.back_end_cinemaproject.dtos;

import lombok.Data;

@Data
public class SeatDTO {
    private int id;
    private String name;
    private int isOccupied;
}

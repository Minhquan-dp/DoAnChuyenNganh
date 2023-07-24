package com.example.client_cinemaproject.models;

import lombok.Data;

@Data
public class SeatDTO {
    private int id;
    private String name;
    private int isOccupied;
}

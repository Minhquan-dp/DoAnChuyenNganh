package com.example.client_cinemaproject.models;

import lombok.Data;

@Data
public class RoomDTO {
    private int id;
    private String name;
    private int capacity;
    private double totalArea;
    private String imgURL;
    private BranchDTO branch;
}

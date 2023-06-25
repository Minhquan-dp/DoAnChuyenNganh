package dev.web.movies.dtos;

import lombok.Data;

@Data
public class SeatDTO {
    private int id;
    private String name;
    private int isOccupied;
}

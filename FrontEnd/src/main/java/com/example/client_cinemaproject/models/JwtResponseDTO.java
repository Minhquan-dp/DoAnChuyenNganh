package com.example.client_cinemaproject.models;

import lombok.Data;

@Data
public class JwtResponseDTO {
    private Integer id;
    private String username;
    private String name;
    private String accessToken;
    private String tokenType;
}

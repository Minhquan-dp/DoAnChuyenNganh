package com.example.back_end_cinemaproject.apis;


import com.example.back_end_cinemaproject.dtos.SeatDTO;
import com.example.back_end_cinemaproject.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/seats")
public class SeatApi {
    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<SeatDTO> getSeatsByScheduleId(@RequestParam Integer scheduleId){
        return seatService.getSeatsByScheduleId(scheduleId);
    }
}

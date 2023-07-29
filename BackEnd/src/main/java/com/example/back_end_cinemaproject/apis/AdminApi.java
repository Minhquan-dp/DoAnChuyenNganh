package com.example.back_end_cinemaproject.apis;

import com.example.back_end_cinemaproject.dtos.BranchDTO;
import com.example.back_end_cinemaproject.dtos.MovieDTO;
import com.example.back_end_cinemaproject.dtos.RoomDTO;
import com.example.back_end_cinemaproject.dtos.TicketDTO;
import com.example.back_end_cinemaproject.services.MovieService;
import com.example.back_end_cinemaproject.services.RoomService;
import com.example.back_end_cinemaproject.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/admin_home", produces = "application/json")
public class AdminApi {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private RoomService roomService;

    @GetMapping
    public void checkAdminAccess() {
    }

    @GetMapping("/getMovies")
    public ResponseEntity<List<MovieDTO>> findAllShowingMovies(){
        return new ResponseEntity<>(movieService.findAllShowingMovies(), HttpStatus.OK);
    }

    @GetMapping("/deleteMovie")
    private String getMoviesAfterDelete(@RequestParam Integer movieId){
        movieService.deleteMovie(movieId);
        return "success";
    }

    @PostMapping(value = "/addMovie")
    public String addMovie(@RequestBody MovieDTO movieDTO) {
        System.out.println(movieDTO.toString());
        movieService.addMovie(movieDTO);
        return "success";
    }

    @PostMapping("/updateMovie")
    public String updateMovie(@RequestBody MovieDTO movieDTO) {
        System.out.println(movieDTO.toString());
        movieService.updateMovie(movieDTO);
        return "success";
    }

}

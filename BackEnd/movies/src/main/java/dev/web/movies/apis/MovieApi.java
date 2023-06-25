package dev.web.movies.apis;

import dev.web.movies.dtos.MovieDTO;
import dev.web.movies.entities.Movie;
import dev.web.movies.repositories.IMovieRepository;
import dev.web.movies.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/movies", produces = "application/json")
public class MovieApi {
    @Autowired
    private IMovieService movieService;

    @Autowired
    private IMovieRepository movieRepository;

    @GetMapping("/showing")
    public ResponseEntity<List<MovieDTO>> findAllShowingMovies(){
        return new ResponseEntity<>(movieService.findAllShowingMovies(), HttpStatus.OK);
    }

    @GetMapping("/details")
    public MovieDTO getMovieById(@RequestParam Integer movieId){
        return movieService.getById(movieId);
    }

    @GetMapping("/showing/search")
    public List<MovieDTO> findAllShowingMoviesByName(@RequestParam String name){
        return movieService.findAllShowingMoviesByName(name);
    }

    @PostMapping
    public void updateMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
    }
}

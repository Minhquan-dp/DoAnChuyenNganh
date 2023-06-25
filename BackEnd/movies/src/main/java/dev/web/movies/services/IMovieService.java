package dev.web.movies.services;


import dev.web.movies.dtos.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> findAllShowingMovies();
    MovieDTO getById(Integer movieId);
    List<MovieDTO> findAllShowingMoviesByName(String name);
}

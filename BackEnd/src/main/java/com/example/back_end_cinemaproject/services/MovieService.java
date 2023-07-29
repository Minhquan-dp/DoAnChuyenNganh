package com.example.back_end_cinemaproject.services;

import com.example.back_end_cinemaproject.dtos.MovieDTO;
import com.example.back_end_cinemaproject.entities.Movie;
import com.example.back_end_cinemaproject.repositories.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<MovieDTO> findAllShowingMovies() {
        return movieRepository.findMoviesByIsShowingOrderByIdDesc(1)
                .stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    public MovieDTO getById(Integer movieId) {
        return modelMapper.map(movieRepository.getById(movieId),MovieDTO.class);
    }

    public List<MovieDTO> findAllShowingMoviesByName(String keyword) {
        return movieRepository.findMoviesByIsShowingAndNameContaining(1,keyword)
                .stream().map(movie -> modelMapper.map(movie,MovieDTO.class))
                .collect(Collectors.toList());
    }


    public boolean deleteMovie(int id) {
        try {
            movieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addMovie(MovieDTO movieDTO) {
        Movie newMovie = new Movie();

        newMovie.setName(movieDTO.getName());
        newMovie.setSmallImageURl(movieDTO.getSmallImageURl());
        newMovie.setShortDescription(movieDTO.getShortDescription());
        newMovie.setLongDescription(movieDTO.getLongDescription());
        newMovie.setLargeImageURL(movieDTO.getLargeImageURL());
        newMovie.setDirector(movieDTO.getDirector());
        newMovie.setActors(movieDTO.getActors());
        newMovie.setCategories(movieDTO.getCategories());
        newMovie.setReleaseDate(movieDTO.getReleaseDate());
        newMovie.setDuration(movieDTO.getDuration());
        newMovie.setTrailerURL(movieDTO.getTrailerURL());
        newMovie.setLanguage(movieDTO.getLanguage());
        newMovie.setRated(movieDTO.getRated());
        newMovie.setIsShowing(1);
        movieRepository.save(newMovie);
    }

    public void updateMovie(MovieDTO movieDTO) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieDTO.getId());

        if (optionalMovie.isPresent()) { System.out.println("co ton tai");
            System.out.println(movieDTO.getName());
            Movie newMovie = optionalMovie.get();
            newMovie.setName(movieDTO.getName());
            newMovie.setSmallImageURl(movieDTO.getSmallImageURl());
            newMovie.setShortDescription(movieDTO.getShortDescription());
            newMovie.setLongDescription(movieDTO.getLongDescription());
            newMovie.setLargeImageURL(movieDTO.getLargeImageURL());
            newMovie.setDirector(movieDTO.getDirector());
            newMovie.setActors(movieDTO.getActors());
            newMovie.setCategories(movieDTO.getCategories());
            newMovie.setReleaseDate(movieDTO.getReleaseDate());
            newMovie.setDuration(movieDTO.getDuration());
            newMovie.setTrailerURL(movieDTO.getTrailerURL());
            newMovie.setLanguage(movieDTO.getLanguage());
            newMovie.setRated(movieDTO.getRated());
            newMovie.setIsShowing(1);
            movieRepository.save(newMovie);
        } else {
            System.out.println("error");
        }
    }
}

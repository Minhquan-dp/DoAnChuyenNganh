package com.example.back_end_cinemaproject.repositories;

import com.example.back_end_cinemaproject.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findMoviesByIsShowingOrderByIdDesc(Integer isShowing);
    List<Movie> findMoviesByIsShowingAndNameContaining(Integer isShowing,String name);
}

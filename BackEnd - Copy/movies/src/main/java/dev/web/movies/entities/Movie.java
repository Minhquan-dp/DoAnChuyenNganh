package dev.web.movies.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Table(name = "movie")
@Entity
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(length = 1000)
    private String smallImageURl;
    @Column(length = 500)
    private String shortDescription;
    @Column(length = 1000)
    private String longDescription;
    @Column(length = 1000)
    private String largeImageURL;
    private String director;
    private String actors;
    private String categories;
    private LocalDate releaseDate;
    private int duration;
    @Column(length = 1000)
    private String trailerURL;
    private String language;
    private String rated;
    private int isShowing;
}

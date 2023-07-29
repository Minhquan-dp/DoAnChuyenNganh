package com.example.client_cinemaproject.controller;

import com.example.client_cinemaproject.constants.Api;
import com.example.client_cinemaproject.models.MovieDTO;
import com.example.client_cinemaproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
//@Controller xác định class xử lý các HTTP và trả về templates
@Controller
@RequestMapping("/")
public class HomeController {
//    @Autowired tự động liên kết các dependency vào class này
    @Autowired
    private RestTemplate restTemplate;

    public static String apiGetShowingMovies = Api.baseURL+"/api/movies/showing";
    public static String API_GET_SHOWING_MOVIES_BY_NAME = Api.baseURL+"/api/movies/showing/search";
//    @GetMapping xử lý HTTP GET đến /
        @GetMapping
        public String displayHomePage(Model model) {
            ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(apiGetShowingMovies, MovieDTO[].class);
            MovieDTO[] movies = response.getBody();
            model.addAttribute("movies", movies);
            model.addAttribute("user", new User());
            return "/Client/home";
        }

    @GetMapping("/suggestion")
    @ResponseBody
    public List<String> getSuggestions(@RequestParam String keyword) {
        ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(apiGetShowingMovies, MovieDTO[].class);
        MovieDTO[] movies = response.getBody();

        List<String> suggestions = new ArrayList<>();
        for (MovieDTO movie : movies) {
            if (movie.getName().toLowerCase().contains(keyword.toLowerCase())) {
                suggestions.add(movie.getName());
            }
        }
       // System.out.println("Suggestions: " + suggestions);
        return suggestions;
    }


    @PostMapping
    public String searchMoviesByName(HttpServletRequest request, Model model){
        // Gọi api lấy ra lịch được chọn
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_SHOWING_MOVIES_BY_NAME)
                .queryParam("name", "{name}")
                .encode()
                .toUriString();
        Map<String,String> listRequestParam = new HashMap<>();
        listRequestParam.put("name", request.getParameter("movie-name"));
        ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(urlTemplate,MovieDTO[].class,listRequestParam);
        MovieDTO[] movies = response.getBody();
        // Không tìm được trả về not-found
        if(movies.length==0){
            return "/Client/movie-not-found";
        }
        model.addAttribute("movies",movies);
        model.addAttribute("user",new User());
        return "/Client/home";
    }
}

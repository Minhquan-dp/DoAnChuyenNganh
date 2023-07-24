package com.example.client_cinemaproject.controller;

import com.example.client_cinemaproject.constants.Api;
import com.example.client_cinemaproject.models.MovieDTO;
import com.example.client_cinemaproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("movie-details")
public class MovieController {
//    Tự động liên kết bean RestTemplate vào restTemplate
//    Lúc này dùng API_GET_MOVIE_DETAILS
    @Autowired
    private RestTemplate restTemplate;

    public static String API_GET_MOVIE_DETAILS = Api.baseURL+"/api/movies/details";
    @GetMapping
    public String displayMovieDetailPage(@RequestParam Integer movieId, Model model){
        // Truyền tham số movieId vào query string rồi gửi request
        // Xử lý yêu cầu để lấy chi tiết phim dựa trên movieId
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_MOVIE_DETAILS)
                .queryParam("movieId", "{movieId}")
                .encode().toUriString(); // Dòng này nhận URL đã xây dựng

        Map<String, Integer> params = new HashMap<>();
        params.put("movieId", movieId);

//        yêu cầu GET tới URL đã xây dựng và truyền tham số
//        Phương thức getForEntity() sẽ thực hiện yêu cầu và trả về một đối tượng
//        ResponseEntity chứa thông tin phản hồi từ API
        ResponseEntity<MovieDTO> response = restTemplate.getForEntity(urlTemplate,MovieDTO.class,params);
        MovieDTO movie = response.getBody();

        // Truyền dữ liệu cho view
        model.addAttribute("movie",movie);
        model.addAttribute("user",new User());

        // Trả về tên view để hiển thị
        return "/Client/movie-details";
    }
}

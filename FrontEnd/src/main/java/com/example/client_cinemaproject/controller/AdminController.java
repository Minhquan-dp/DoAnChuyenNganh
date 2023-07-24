package com.example.client_cinemaproject.controller;

import com.example.client_cinemaproject.constants.Api;
import com.example.client_cinemaproject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin_home")
public class AdminController {
    @Autowired
    private RestTemplate restTemplate;

    public static String apiAdmin = Api.baseURL+"/api/admin_home";
    public static String apiGetShowingMovies = Api.baseURL+"/api/admin_home/getMovies";
    public static String apiDeleteMovie = Api.baseURL+"/api/admin_home/deleteMovie";
    public static String apiAddMovie = Api.baseURL+"/api/admin_home/addMovie";
    public static String apiUpdateMovie = Api.baseURL+"/api/admin_home/updateMovie";
    @GetMapping
    public String adminHome(HttpServletRequest request) {
        HttpSession session = request.getSession();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO)session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION,"Bearer "+jwtResponseDTO.getAccessToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        restTemplate.exchange(apiAdmin, HttpMethod.GET, entity, Void.class);
        return "/Admin/admin_home";
    }
    @GetMapping(value = "/manage_movie")
    public String movieMangamentView(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION,"Bearer "+jwtResponseDTO.getAccessToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<MovieDTO[]> response = restTemplate.exchange(apiGetShowingMovies, HttpMethod.GET,entity,MovieDTO[].class);
        MovieDTO[] movies = response.getBody();
        model.addAttribute("movies",movies);
        return "/Admin/manage_movie";
    }

    @GetMapping(value = "/deleteMovie")
    public ResponseEntity<?> deleteMovie(@RequestParam Integer movieId, HttpServletRequest request) {
        // Gắn movie id vào session lát sau dùng tiếp để tìm ra lịch xem cụ thể dựa trên movie id đó
        HttpSession session = request.getSession();
        session.setAttribute("movieId", movieId);

        // Gắn access token jwt vào header để gửi kèm request
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtResponseDTO.getAccessToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Gửi yêu cầu xóa bộ phim
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(apiDeleteMovie)
                .queryParam("movieId", "{movieId}")
                .encode()
                .toUriString();
        Map<String, Integer> params = new HashMap<>();
        params.put("movieId", movieId);
        restTemplate.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                Void.class,
                params
        );

        // Trả về mã HTTP 204 (No Content) để chỉ rằng yêu cầu đã thành công
        return ResponseEntity.noContent().build();
    }


    @PostMapping(value = "/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movieDTO, HttpServletRequest request) {
        HttpSession session = request.getSession();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtResponseDTO.getAccessToken());
        HttpEntity<MovieDTO> entity = new HttpEntity<>(movieDTO, headers);

        restTemplate.postForObject(apiAddMovie, entity, String.class);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/updateMovie")
    public ResponseEntity<String> updateMovie(@RequestBody MovieDTO movieDTO, HttpServletRequest request) {
        HttpSession session = request.getSession();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtResponseDTO.getAccessToken());
        HttpEntity<MovieDTO> entity = new HttpEntity<>(movieDTO, headers);
        restTemplate.postForObject(apiUpdateMovie, entity, String.class);
        return ResponseEntity.ok().build();
    }
}
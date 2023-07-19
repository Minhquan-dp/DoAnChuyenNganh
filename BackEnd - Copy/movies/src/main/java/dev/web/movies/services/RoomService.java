package dev.web.movies.services;

import com.example.back_end_cinemaproject.dtos.RoomDTO;
import com.example.back_end_cinemaproject.entities.Room;
import com.example.back_end_cinemaproject.repositories.IRoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
    @Service
    public class RoomService {
        @Autowired
        private IRoomRepository roomRepository;

        @Autowired
        private ModelMapper modelMapper;


        public List<RoomDTO> getRooms(Integer movieId, Integer branchId, String startDate, String startTime) {
            return roomRepository.getRoomByBranchAndMovieAndSchedule(movieId,branchId, LocalDate.parse(startDate), LocalTime.parse(startTime))
                    .stream().map(room -> modelMapper.map(room,RoomDTO.class))
                    .collect(Collectors.toList());
        }

        public List<RoomDTO> findAll() {
            List<Room> rooms = roomRepository.findAll();
            return rooms.stream()
                    .map(room -> modelMapper.map(room, RoomDTO.class))
                    .collect(Collectors.toList());
        }

    }

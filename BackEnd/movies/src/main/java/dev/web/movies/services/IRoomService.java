package dev.web.movies.services;

import dev.web.movies.dtos.RoomDTO;

import java.util.List;

public interface IRoomService {
    List<RoomDTO> getRooms(Integer movieId,Integer branchId,String startDate,String startTime);
}

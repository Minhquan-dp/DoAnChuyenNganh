package dev.web.movies.services;

import dev.web.movies.dtos.ScheduleDTO;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleService {
    List<String> getStartTimes(Integer movieId, Integer branchId, LocalDate startDate);
    List<ScheduleDTO> getSchedules(Integer movieId,Integer branchId,String startDate, String startTime,
                                   Integer roomId);
}

package com.example.back_end_cinemaproject.services;

import com.example.back_end_cinemaproject.dtos.TicketDTO;
import com.example.back_end_cinemaproject.repositories.ITicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService{
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<TicketDTO> getTicketsByUserId(Integer userId) {
        return ticketRepository.findTicketsByUserId(userId)
                .stream().map(ticket -> modelMapper.map(ticket,TicketDTO.class))
                .collect(Collectors.toList());
    }
}

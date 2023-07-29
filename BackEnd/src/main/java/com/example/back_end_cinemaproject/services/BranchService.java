package com.example.back_end_cinemaproject.services;

import com.example.back_end_cinemaproject.dtos.BranchDTO;
import com.example.back_end_cinemaproject.repositories.IBranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService {

    @Autowired
    private IBranchRepository branchRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<BranchDTO> getBranchesThatShowTheMovie(Integer movieId) {
        return branchRepository.getBranchThatShowTheMovie(movieId)
                .stream().map(branch -> modelMapper.map(branch, BranchDTO.class))
                .collect(Collectors.toList());
    }
}

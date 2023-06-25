package dev.web.movies.services;

import dev.web.movies.dtos.BranchDTO;

import java.util.List;

public interface IBranchService {
    List<BranchDTO> getBranchesThatShowTheMovie(Integer movieId);
}

package dev.web.movies.repositories;

import dev.web.movies.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill, Integer> {
}
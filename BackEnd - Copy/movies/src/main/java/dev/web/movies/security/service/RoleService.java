package dev.web.movies.security.service;

import com.example.back_end_cinemaproject.entities.Role;
import com.example.back_end_cinemaproject.security.repo.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepository;


    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }


    public Role save(Role role) {
        return roleRepository.save(role);
    }


    public void remove(Integer id) {
        roleRepository.deleteById(id);
    }


    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}

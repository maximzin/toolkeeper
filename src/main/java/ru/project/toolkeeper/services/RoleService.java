package ru.project.toolkeeper.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.toolkeeper.models.Role;
import ru.project.toolkeeper.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
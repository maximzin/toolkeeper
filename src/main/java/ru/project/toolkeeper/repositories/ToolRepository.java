package ru.project.toolkeeper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.toolkeeper.models.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {
}

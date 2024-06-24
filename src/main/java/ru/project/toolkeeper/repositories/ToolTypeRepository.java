package ru.project.toolkeeper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.toolkeeper.models.ToolType;

@Repository
public interface ToolTypeRepository extends JpaRepository<ToolType, Integer> {

}

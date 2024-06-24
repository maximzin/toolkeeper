package ru.project.toolkeeper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.toolkeeper.models.CellAndTools;

import java.util.List;

@Repository
public interface CellAndToolsRepository extends JpaRepository<CellAndTools, Integer> {
    List<CellAndTools> findByIdCellOrderById(int id);

    void deleteByIdCell(int id);
}

package ru.project.toolkeeper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.toolkeeper.models.Cell;

import java.util.List;

@Repository
public interface CellRepository extends JpaRepository<Cell, Integer> {

    List<Cell> findByIdClosetOrderByNumber(int id_closet);

    void deleteByIdCloset(int id_closet);

    List<Cell> findByIdClosetAndNumber(int id_closet, int number);

}

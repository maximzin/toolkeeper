package ru.project.toolkeeper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.toolkeeper.models.Closet;

import java.util.List;

@Repository
public interface ClosetRepository extends JpaRepository<Closet, Integer> {
    List<Closet> findByIdCehOrderByName(int id_ceh);

}

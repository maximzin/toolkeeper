package ru.project.toolkeeper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.toolkeeper.models.Ceh;

@Repository
public interface CehRepository extends JpaRepository<Ceh, Integer> {
}

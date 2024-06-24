package ru.project.toolkeeper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.toolkeeper.models.ClosetType;

@Repository
public interface ClosetTypeRepository extends JpaRepository<ClosetType, Integer> {

}

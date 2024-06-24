package ru.project.toolkeeper.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.toolkeeper.models.ClosetType;
import ru.project.toolkeeper.repositories.ClosetTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ClosetTypeService {
    
    private final ClosetTypeRepository closetTypeRepository;

    @Autowired
    public ClosetTypeService(ClosetTypeRepository closetTypeRepository) {
        this.closetTypeRepository = closetTypeRepository;
    }

    public List<ClosetType> findAll() {
        return closetTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public ClosetType findOne(int id) {
        Optional<ClosetType> foundClosetType = closetTypeRepository.findById(id);

        return foundClosetType.orElse(null);
    }

    @Transactional
    public void saveClosetType(ClosetType ceh) {closetTypeRepository.save(ceh);
    }

    @Transactional
    public void updateClosetType(int id, ClosetType updatedClosetType) {
        updatedClosetType.setId(id);
        closetTypeRepository.save(updatedClosetType);
    }

    @Transactional
    public void deleteClosetType(int id) {
        closetTypeRepository.deleteById(id);
    }

    public int getCapacity(int id_type) {
        return closetTypeRepository.findById(id_type).stream().findAny().get().getCapacity();
    }
}

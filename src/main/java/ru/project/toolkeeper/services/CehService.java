package ru.project.toolkeeper.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.toolkeeper.models.Ceh;
import ru.project.toolkeeper.repositories.CehRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CehService {

    private final CehRepository cehRepository;

    @Autowired
    public CehService(CehRepository cehRepository) {
        this.cehRepository = cehRepository;
    }

    public List<Ceh> findAll() {
        return cehRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Ceh findOne(int id) {
        Optional<Ceh> foundCeh = cehRepository.findById(id);

        return foundCeh.orElse(null);
    }

    @Transactional
    public void saveCeh(Ceh ceh) {cehRepository.save(ceh);
    }

    @Transactional
    public void updateCeh(int id, Ceh updatedCeh) {
        updatedCeh.setId(id);
        cehRepository.save(updatedCeh);
    }

    @Transactional
    public void deleteCeh(int id) {
        cehRepository.deleteById(id);
    }

}

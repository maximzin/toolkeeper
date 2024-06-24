package ru.project.toolkeeper.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.toolkeeper.models.CellAndTools;
import ru.project.toolkeeper.repositories.CellAndToolsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CellAndToolsService {
    
    private final CellAndToolsRepository cellAndToolsRepository;
    
    @Autowired
    public CellAndToolsService(CellAndToolsRepository cellAndToolsRepository) {
        this.cellAndToolsRepository = cellAndToolsRepository;
    }

    public List<CellAndTools> findAll() {
        return cellAndToolsRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public CellAndTools findById(int id) {
        Optional<CellAndTools> foundCellAndTools = cellAndToolsRepository.findById(id);
        return foundCellAndTools.orElse(null);
    }

    public List<CellAndTools> findByIdCell(int id_cell) {
        return cellAndToolsRepository.findByIdCellOrderById(id_cell);
    }

    @Transactional
    public void saveCellAndTools(CellAndTools cellAndTools) {cellAndToolsRepository.save(cellAndTools);
    }

    @Transactional
    public void updateCellAndTools(int id, CellAndTools updatedCellAndTools) {
        updatedCellAndTools.setId(id);
        cellAndToolsRepository.save(updatedCellAndTools);
    }

    @Transactional
    public void deleteCellsAndTools(int id) {
        cellAndToolsRepository.deleteByIdCell(id);
    }

    @Transactional
    public void deleteCellAndTools(int id) {
        cellAndToolsRepository.deleteById(id);
    }

}

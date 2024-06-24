package ru.project.toolkeeper.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.toolkeeper.models.Tool;
import ru.project.toolkeeper.repositories.ToolRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ToolService {
    
    private final ToolRepository toolRepository;

    @Autowired
    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public List<Tool> findAll() {
        return toolRepository.findAll();
    }

    public Tool findOne(int id) {
        Optional<Tool> foundTool = toolRepository.findById(id);
        return foundTool.orElse(null);
    }

    @Transactional
    public void saveTool(Tool tool) {
        toolRepository.save(tool);
    }

    @Transactional
    public void updateTool(int id, Tool updatedTool) {
        updatedTool.setId(id);
        toolRepository.save(updatedTool);
    }

    @Transactional
    public void deleteTool(int id) {
        toolRepository.deleteById(id);
    }
    
}

package ru.project.toolkeeper.contollers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.project.toolkeeper.models.ToolType;
import ru.project.toolkeeper.services.ToolTypeService;

@Controller
@RequestMapping("/tooltype")
public class ToolTypeController {

    private final ToolTypeService toolTypeService;

    @Autowired
    public ToolTypeController(ToolTypeService toolTypeService) {
        this.toolTypeService = toolTypeService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("toolTypes", toolTypeService.findAll());
        return "tooltype/showall";
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("toolType", toolTypeService.findOne(id));
        return "tooltype/showone";
    }

    @GetMapping("/new")
    public String newToolType(@ModelAttribute("toolType") ToolType toolType) {
        return "tooltype/new";
    }

    @PostMapping()
    public String createToolType(@ModelAttribute("toolType") @Valid ToolType toolType,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "tooltype/new";

        toolTypeService.saveToolType(toolType);
        return "redirect:/tooltype";
    }

    @GetMapping("/{id}/edit")
    public String editToolType(Model model, @PathVariable("id") int id) {
        model.addAttribute("toolType", toolTypeService.findOne(id));
        return "tooltype/edit";
    }

    @PatchMapping("/{id}")
    public String updateToolType(Model model, @ModelAttribute("toolType") @Valid ToolType toolType, BindingResult bindingResult,
                                   @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "tooltype/edit";

        toolTypeService.updateToolType(id, toolType);
        return "redirect:/tooltype/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteToolType(@PathVariable("id") int id) {
        toolTypeService.deleteToolType(id);
        return "redirect:/tooltype";
    }

}

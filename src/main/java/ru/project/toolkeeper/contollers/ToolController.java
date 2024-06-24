package ru.project.toolkeeper.contollers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.project.toolkeeper.models.Tool;
import ru.project.toolkeeper.models.ToolType;
import ru.project.toolkeeper.services.ToolService;
import ru.project.toolkeeper.services.ToolTypeService;

@Controller
@RequestMapping("/tool")
public class ToolController {

    private final ToolService toolService;

    private final ToolTypeService toolTypeService;

    @Autowired
    public ToolController(ToolService toolService, ToolTypeService toolTypeService ) {
        this.toolService = toolService;
        this.toolTypeService = toolTypeService;
    }

    @GetMapping()
    public String ShowAll(Model model) {
        model.addAttribute("tools", toolService.findAll());
        return "tool/showall";
    }

    @GetMapping("/{id}")
    public String id(@PathVariable("id") int id, Model model) {
        model.addAttribute("tool", toolService.findOne(id));
        return "tool/showone";
    }

    @GetMapping("/new")
    public String newTool(Model model, @ModelAttribute("tool") Tool tool,
                          @ModelAttribute("type") ToolType toolType) {
        model.addAttribute("types", toolTypeService.findAll());
        return "tool/new";
    }

    @PostMapping()
    public String createTool(Model model, @ModelAttribute("tool") @Valid Tool tool,
                         BindingResult bindingResult) {
        model.addAttribute("types", toolTypeService.findAll());
        if (bindingResult.hasErrors())
            return "tool/new";
        toolService.saveTool(tool);
        return "redirect:/tool";
    }

    @GetMapping("/{id}/edit")
    public String editTool(Model model, @PathVariable("id") int id,
                           @ModelAttribute("type") ToolType toolType) {
        model.addAttribute("tool", toolService.findOne(id));
        model.addAttribute("types", toolTypeService.findAll());
        return "tool/edit";
    }

    @PatchMapping("/{id}")
    public String updateTool(Model model, @ModelAttribute("tool") @Valid Tool tool, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "tool/edit";

        toolService.updateTool(id, tool);
        return "redirect:/tool/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteTool(@PathVariable("id") int id) {
        toolService.deleteTool(id);
        return "redirect:/tool";
    }
    
}

package ru.project.toolkeeper.contollers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.project.toolkeeper.models.ClosetType;
import ru.project.toolkeeper.services.ClosetTypeService;

@Controller
@RequestMapping("/closettype")
public class ClosetTypeController {

    private final ClosetTypeService closetTypeService;

    @Autowired
    public ClosetTypeController(ClosetTypeService closetTypeService) {
        this.closetTypeService = closetTypeService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("closetTypes", closetTypeService.findAll());
        return "closettype/showall";
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("closetType", closetTypeService.findOne(id));
        return "closettype/showone";
    }

    @GetMapping("/new")
    public String newClosetType(@ModelAttribute("closetType") ClosetType closetType) {
        return "closettype/new";
    }

    @PostMapping()
    public String createClosetType(@ModelAttribute("closetType") @Valid ClosetType closetType,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "closettype/new";

        closetTypeService.saveClosetType(closetType);
        return "redirect:/closettype";
    }

    @GetMapping("/{id}/edit")
    public String editClosetType(Model model, @PathVariable("id") int id) {
        model.addAttribute("closetType", closetTypeService.findOne(id));
        return "closettype/edit";
    }

    @PatchMapping("/{id}")
    public String updateClosetType(Model model, @ModelAttribute("closetType") @Valid ClosetType closetType, BindingResult bindingResult,
                                   @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "closettype/edit";

        closetTypeService.updateClosetType(id, closetType);
        return "redirect:/closettype/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteClosetType(@PathVariable("id") int id) {
        closetTypeService.deleteClosetType(id);
        return "redirect:/closettype";
    }

}

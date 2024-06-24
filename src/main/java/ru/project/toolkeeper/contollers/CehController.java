package ru.project.toolkeeper.contollers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.project.toolkeeper.models.Ceh;
import ru.project.toolkeeper.services.CehService;
import ru.project.toolkeeper.services.ClosetService;

@Controller
@RequestMapping("/ceh")
public class CehController {

    private final CehService cehService;

    private final ClosetService closetService;

    @Autowired
    public CehController(CehService cehService, ClosetService closetService) {
        this.cehService = cehService;
        this.closetService = closetService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("cehs", cehService.findAll());
        return "ceh/showall";
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("ceh", cehService.findOne(id));
        return "ceh/showone";
    }

    @GetMapping("/new")
    public String newCeh(@ModelAttribute("ceh") Ceh ceh) {
        return "ceh/new";
    }

    @PostMapping()
    public String createCeh(@ModelAttribute("ceh") @Valid Ceh ceh,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "ceh/new";
        cehService.saveCeh(ceh);
        return "redirect:/ceh";
    }

    @GetMapping("/{id}/edit")
    public String editCeh(Model model, @PathVariable("id") int id) {
        model.addAttribute("ceh", cehService.findOne(id));
        return "ceh/edit";
    }

    @PatchMapping("/{id}")
    public String updateCeh(Model model, @ModelAttribute("ceh") @Valid Ceh ceh, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "ceh/edit";

        cehService.updateCeh(id, ceh);
        return "redirect:/ceh/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteCeh(@PathVariable("id") int id) {
        cehService.deleteCeh(id);
        return "redirect:/ceh";
    }

}

package ru.project.toolkeeper.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.project.toolkeeper.services.UserService;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final UserService userService;

    public MainPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String begin() {
        return "mainpage";
    }

}

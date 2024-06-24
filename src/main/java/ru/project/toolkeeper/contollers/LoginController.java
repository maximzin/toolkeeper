package ru.project.toolkeeper.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Возвращает имя страницы входа
    }

    @PostMapping("/login")
    public String processLogin() {
        // Обработка аутентификации с помощью Spring Security
        return "redirect:/"; // Перенаправление на запрещенную страницу
    }
}
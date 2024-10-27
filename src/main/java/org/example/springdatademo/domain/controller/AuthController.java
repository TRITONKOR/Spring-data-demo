package org.example.springdatademo.domain.controller;

import org.example.springdatademo.domain.service.ClientService;
import org.example.springdatademo.persistence.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private ClientService clientService;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        logger.info("Спроба зареєструвати користувача:");
        model.addAttribute("client", new Client());
        return "register";
    }

    @PostMapping("/register")
    public String registerClient(@ModelAttribute Client client, Model model) {
        logger.info("Спроба зареєструвати користувача: {}", client.getUsername());
        try {
            clientService.registerClient(client);
            model.addAttribute("message", "Реєстрація успішна! Ви можете увійти.");
            return "login";
        } catch (Exception e) {
            System.out.println("gfdgfdgfdgdfgd");
            logger.error("Помилка при реєстрації користувача: {}", e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        logger.info("Спроба авторизації");
        return "login";
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "user_home";
    }

    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin_home";
    }
}

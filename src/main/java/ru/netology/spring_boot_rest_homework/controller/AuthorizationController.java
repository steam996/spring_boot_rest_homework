package ru.netology.spring_boot_rest_homework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.spring_boot_rest_homework.authorities.Authorities;
import ru.netology.spring_boot_rest_homework.resolver.Resolver;
import ru.netology.spring_boot_rest_homework.service.AuthorizationService;
import ru.netology.spring_boot_rest_homework.user.User;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Resolver User user) {
        return service.getAuthorities(user);
    }

}

package ru.netology.spring_boot_rest_homework.service;

import org.springframework.stereotype.Service;
import ru.netology.spring_boot_rest_homework.authorities.Authorities;
import ru.netology.spring_boot_rest_homework.exception.InvalidCredentials;
import ru.netology.spring_boot_rest_homework.exception.UnauthorizedUser;
import ru.netology.spring_boot_rest_homework.repository.UserRepository;
import ru.netology.spring_boot_rest_homework.user.User;

import java.util.List;

@Service
public class AuthorizationService {

    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        String login = user.getLogin();
        String password = user.getPassword();
        if (isEmpty(login) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(login, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + login);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

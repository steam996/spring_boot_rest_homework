package ru.netology.spring_boot_rest_homework.repository;

import org.springframework.stereotype.Repository;
import ru.netology.spring_boot_rest_homework.authorities.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<String, String> usersMap = new ConcurrentHashMap();
    private ConcurrentHashMap<String, List<Authorities>> usersAuthoritiesMap = new ConcurrentHashMap();

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (usersMap.containsKey(user) && usersMap.get(user).equals(password)) return usersAuthoritiesMap.get(user);
        else return Collections.emptyList();

    }

}

package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<User> getUsers();

    @Transactional
    User userInfo(int id);

    @Transactional
    void remove(int id);

    @Transactional
    void refresh(int id, User user);

    @Transactional
    void persist(User user);
}

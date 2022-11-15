package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<User> getUsers();

    @Transactional
    User userInfo(long id);


    void remove(long id);

    @Transactional
    void refresh(long id, User user);

    @Transactional
    void persist(User user);
}

package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> getUsers();


    User userInfo(long id);


    void remove(long id);

    void refresh(long id, User user);

    void persist(User user);
}

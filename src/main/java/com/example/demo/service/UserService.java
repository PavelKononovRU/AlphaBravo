package com.example.demo.service;

import com.example.demo.model.User;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    User userInfo(int id);

    void remove(int id);

    void refresh(int id, User user) throws NotFoundException;

    void persist(User user);
}

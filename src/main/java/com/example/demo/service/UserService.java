package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> findById(int id);

    void delete(int id);

    void update(int id, User user);

    void save(User user);
}

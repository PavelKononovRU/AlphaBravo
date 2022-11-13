package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
    @Override
    public List<User> findById(int id) {
        return userDAO.findById((long) id).stream().toList();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void save(User user) {

    }
}
/*
    @Override
    public User findById(int id) {
        return userDaoImpl.findById(id);
    }

    @Override
    public void delete(int id) {
        userDaoImpl.delete(id);
    }

    @Override
    public void update(int id, User user) {
        userDaoImpl.update(id, user);
    }

    @Override
    public void save(User user) {
        userDaoImpl.save(user);
    }
}*/

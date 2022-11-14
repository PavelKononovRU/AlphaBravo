package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    @Transactional
    @Override
    public User userInfo(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void remove(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
    }
    @Transactional
    @Override
    public void refresh(int id, User user) {
        User userForUpdate = userInfo(id);
        userForUpdate.setName(user.getName());
        userForUpdate.setSurname(user.getSurname());
        userForUpdate.setEmail(user.getEmail());
        userForUpdate.setAge(user.getAge());
        userRepository.save(userForUpdate);
    }
    @Transactional
    @Override
    public void persist(User user) {
        userRepository.save(user);
    }
}

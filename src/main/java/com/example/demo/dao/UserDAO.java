package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDAO extends CrudRepository<User, Long> {
    List<User> findAll();
/*    User findById(int id);

    void delete(int id);

    void update(int id, User user);

    void save(User user);*/
}

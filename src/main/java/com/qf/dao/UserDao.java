package com.qf.dao;

import com.qf.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(int id);
    boolean delete(int id);
    boolean insert(User user);
    boolean update(User user);
}

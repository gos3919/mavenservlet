package com.qf.service;

import com.qf.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    boolean delete(int id);
    boolean insert(User user);
    boolean update(User user);
}

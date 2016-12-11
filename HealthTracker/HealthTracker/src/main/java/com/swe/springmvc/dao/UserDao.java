package com.swe.springmvc.dao;

import java.util.List;

import com.swe.springmvc.model.User;
 
 
public interface UserDao {
 
    User findById(int id);
     
    User findByUsername(String username);
     
    void save(User user);
     
    void deleteByUsername(String username);
     
    List<User> findAllUsers();
 
}

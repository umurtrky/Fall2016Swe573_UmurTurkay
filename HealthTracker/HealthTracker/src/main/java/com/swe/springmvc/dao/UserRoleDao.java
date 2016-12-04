package com.swe.springmvc.dao;

import java.util.List;

import com.swe.springmvc.model.UserRole;
 
 
public interface UserRoleDao {
 
    List<UserRole> findAll();
     
    UserRole findByType(String type);
     
    UserRole findById(int id);
}

package com.marian.university.service;

import com.marian.university.entity.User;

import java.util.List;

public interface UserService {
void save(User user);
List<User> findAll();
User getOne(int id);
List<User> getAllTeacher();
}

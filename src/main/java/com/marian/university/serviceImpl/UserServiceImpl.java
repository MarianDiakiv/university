package com.marian.university.serviceImpl;

import com.marian.university.entity.ERoles;
import com.marian.university.entity.User;
import com.marian.university.repository.UserRepository;
import com.marian.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAllTeacher() {
        return userRepository.getUserByRole(ERoles.ROLE_TEACHER);
    }
}

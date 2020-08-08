package com.marian.university.service;

import com.marian.university.entity.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {
    List<Role> getAll();
    void save(Role role);
}

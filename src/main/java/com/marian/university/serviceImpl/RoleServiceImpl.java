package com.marian.university.serviceImpl;

import com.marian.university.entity.Role;
import com.marian.university.repository.RoleRepository;
import com.marian.university.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Role role) {
        System.out.println(role.getNameRole());
        roleRepository.save(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();

    }
}

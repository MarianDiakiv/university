package com.marian.university.mapper;

import com.marian.university.dto.RoleDTO;
import com.marian.university.entity.Role;
import com.marian.university.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class RoleMapper {
    @Autowired
    private RoleRepository roleRepository;


    public RoleDTO roleToDto(Role role){
        RoleDTO  dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setNameRole(role.getNameRole());
        return dto;
    }
    public Set<RoleDTO> roleToDto(Set<Role> roles){
        Set<RoleDTO> dtos = new HashSet<>();
        for (Role role:roles){
            RoleDTO  dto = new RoleDTO();
            dto.setId(role.getId());
            dto.setNameRole(role.getNameRole());
            dtos.add(dto);
        }
        return dtos;
    }
    public Set<Role> dtoToEntity(Set<RoleDTO> dtos){
        Set<Role> roles = new HashSet<>();
        for (RoleDTO dto: dtos){
            Role role = new Role();
            role.setId(dto.getId());
            role.setNameRole(dto.getNameRole());
            roles.add(role);
        }
        return roles;
    }
}

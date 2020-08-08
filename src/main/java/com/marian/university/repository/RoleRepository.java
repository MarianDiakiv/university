package com.marian.university.repository;

import com.marian.university.entity.ERoles;
import com.marian.university.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByNameRole(ERoles name);
}

package com.marian.university.repository;

import com.marian.university.entity.ERoles;
import com.marian.university.entity.Role;
import com.marian.university.entity.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUsersByEmail(String email);
    @Query("select  u from User  u where u.email =:email")
    User findUserByEmail( @Param("email") String email);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);


    @Query("select distinct u from User u join u.role r where r.nameRole =:role ")
    List<User> getUserByRole(@Param("role") ERoles role);
}

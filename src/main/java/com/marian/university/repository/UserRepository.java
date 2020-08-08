package com.marian.university.repository;

import com.marian.university.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUsersByEmail(String email);
    @Query("select  u from User  u where u.email =:email")
    User findUserByEmail( @Param("email") String email);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);

}

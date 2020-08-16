package com.marian.university.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marian.university.security.services.UserDetailsImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Integer id;
    private String username;
    private  String email;
    private  String token;
    @JsonIgnore
    private String password;
    private List<String> roles;





    public UserModel(UserDetailsImpl details, String jwt){
        this.id = details.getId();
        this.username = details.getUsername();
        this.email = details.getEmail();
        this.password = details.getPassword();
        this.token = jwt;


        this.roles = details.getAuthorities().stream()
                .map(item-> item.getAuthority())
                .collect(Collectors.toList());
    }
    public UserModel(Integer id, String username, String email, String token, String password, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.token = token;
        this.password = password;
        this.roles = roles;

    }

    public UserModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

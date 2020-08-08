package com.marian.university.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {
    @Size(min = 5,max=30)
    private String username;
    @Email
    private String email;
    private Set<String> role;
    @Size(min = 4,max = 30)
    private String password;

    public SignupRequest() {
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

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

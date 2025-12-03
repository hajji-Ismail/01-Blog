package com.example.backend.Auth.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "user_role")
public class user_role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = false)
    private Long users_id;

   @Column(nullable = false, unique = false)
    private Long rol_id ;

    
@Column(nullable = true)
    private LocalDateTime createdAt = LocalDateTime.now();

    user_role(Long user_id,Long user_role){
        this.rol_id = rol_id;
        this.users_id = users_id;
        this.createdAt = LocalDateTime.now();

    }
    public user_role(){}
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public Long getRol_id() {
        return rol_id;
    }
    public Long getUsers_id() {
        return users_id;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setRol_id(Long rol_id) {
        this.rol_id = rol_id;
    }
    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
    }

}
    

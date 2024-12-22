package com.themeshop.themeshop.repository;

import com.themeshop.themeshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
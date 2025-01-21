package com.templateshop.templateshop.repository;

import com.templateshop.templateshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
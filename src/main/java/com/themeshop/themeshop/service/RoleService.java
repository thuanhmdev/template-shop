package com.themeshop.themeshop.service;

import com.themeshop.themeshop.model.Role;
import com.themeshop.themeshop.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleService")
public class RoleService {
    final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @PostConstruct
    public void init() {
        if(roleRepository.count() <=2 ) {
            createRole("ADMIN", "FULL quyền");
            createRole("USER", "Người dùng");
        }
    }

    public void createRole(String name, String desc){
        Role role = new Role();
        role.setName(name);
        role.setDescription(desc);
        this.roleRepository.save(role);
    }

    public List<Role> getAllRole() {
        return this.roleRepository.findAll();
    }

}

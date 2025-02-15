package com.templateshop.templateshop.service;

import com.templateshop.templateshop.dto.RegisterDTO;
import com.templateshop.templateshop.model.User;
import com.templateshop.templateshop.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserRepository userRepository;
    private RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }


    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public long countUsers() {
        return this.userRepository.count();
    }

    public User getUserById(String id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public void updateUser(User currentUser, User user) {
        currentUser.setAddress(user.getAddress());
        currentUser.setFullName(user.getFullName());
        currentUser.setPhone(user.getPhone());
        currentUser.setRole(user.getRole());
        this.userRepository.save(currentUser);
    }

    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

    public Boolean checkEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public void registerUser(RegisterDTO registerDTO) {
        System.out.println(registerDTO.getPassword());
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        user.setFullName(registerDTO.getFullName());
        user.setRole(this.roleService.getRoleUser());
        this.userRepository.save(user);
    }

}

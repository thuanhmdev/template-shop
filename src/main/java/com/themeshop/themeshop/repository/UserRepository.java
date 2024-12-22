package com.themeshop.themeshop.repository;

import com.themeshop.themeshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>  {
}

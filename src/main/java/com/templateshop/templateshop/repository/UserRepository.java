package com.templateshop.templateshop.repository;

import com.templateshop.templateshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>  {
}

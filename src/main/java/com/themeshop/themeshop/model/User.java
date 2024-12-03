package com.themeshop.themeshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Email(message = "Email không hợp lệ", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+@[a-zA-Z0-9.]+$")
    private String email;

    @NotNull
    @Size(min = 2, message = "Password phải có tối thiểu 2 ký tự")
    private String password;

    @NotNull
    @Size(min = 3, message = "Fullname phải có tối thiểu 3 ký tự")
    private String fullName;
    private String address;
    private String phone;
    private String avatar;
    private String demoLink;
    private String sourceLink;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}

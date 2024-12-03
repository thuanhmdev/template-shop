package com.themeshop.themeshop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<User> users;

}

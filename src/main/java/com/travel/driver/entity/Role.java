package com.travel.driver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_role_id")
    private Long id;
    @Column(name = "_role_name", nullable = false, unique = true)
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

}

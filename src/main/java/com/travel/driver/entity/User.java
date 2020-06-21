package com.travel.driver.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_user_id", nullable = false)
    private Long id;
    @Column(name = "_first_name", nullable = false)
    private String firstName;
    @Column(name = "_second_name", nullable = false)
    private String secondName;
    @Column(name = "_patronymic", nullable = false)
    private String patronymic;
    @Column(name = "_email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "_user_role",
            joinColumns = @JoinColumn(name = "_user_id", referencedColumnName = "_user_id", foreignKey = @ForeignKey(name = "_user_id_FK")),
            inverseJoinColumns = @JoinColumn(name = "_role_id", referencedColumnName = "_role_id", foreignKey = @ForeignKey(name = "_role_id_FK"))
    )
    private List<Role> roles = new ArrayList<>();

    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }

}

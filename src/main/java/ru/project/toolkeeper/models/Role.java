package ru.project.toolkeeper.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    public Role() {}
    public Role(String name) {
        this.name = name;
    }

}

package ru.project.toolkeeper.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tool_type")
public class ToolType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 1, max = 50, message = "Название должно содержать от 1 до 50 символов")
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    public ToolType() {}

    public ToolType(String name) {
        this.name = name;
    }
}

